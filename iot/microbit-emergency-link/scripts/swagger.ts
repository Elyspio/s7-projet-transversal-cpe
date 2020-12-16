import {createWriteStream, promises} from "fs"
import * as path from "path";
import axios from "axios";
import {execSync} from "child_process";

const {readdir, readFile, writeFile, stat, unlink} = promises;

const config = {
    app: path.join(__dirname, "generator.jar"),
    url: "https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.23/swagger-codegen-cli-3.0.23.jar",
    format: "typescript-axios"
}


async function listFileRecursively(p: string, filter?: (f: string) => boolean) {
    console.log("path", p)
    let files = (await readdir(p)).map(f => path.resolve(p, f));

    for (const f of files) {
        const fPath = path.resolve(p, f);
        if ((await stat(fPath)).isDirectory()) {
            files = files.filter(ff => f !== ff);
            files.push(
                ...(await listFileRecursively(fPath)).map(f => path.resolve(fPath, f))
            )
        }
    }

    if (filter) {
        files = files.filter(f => filter(f))
    }

    return files;

}


async function removeNonTsFiles(folder: string) {
    const files = await listFileRecursively(folder, p => p.slice(-3) === ".ts")
    await Promise.all(files.map(unlink))
}

async function ensureTsFilesContent(folder: string) {
    const files = await listFileRecursively(folder, p => p.slice(-3) === ".ts")
    await Promise.all(
        files.map(async f => {
            if((await readFile(f)).toString().length === 0) {
                await writeFile(f, "export {}")
            }
        })
    )
}


async function generate(host: string, output: string) {
    try {
        await stat(config.app)
    } catch (e) {
        await axios({
            method: "get",
            url: host,
            responseType: "stream"
        }).then(function (response) {
            response.data.pipe(createWriteStream(config.app));
        });
    }

    execSync(`java -jar ${config.app} generate -i ${host} -l ${config.format} -o ${output}`);
    await removeNonTsFiles(output);
    await ensureTsFilesContent(output);
}

generate()
