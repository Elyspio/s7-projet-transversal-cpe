const {copy, remove} = require("fs-extra")
const path = require("path")

const src = path.resolve(__dirname, "src");

const dests = {
    emergency: path.resolve(__dirname, "..", "..", "core", "emergency-manager",  "microbit-emergency-link", "src", "shared"),
    simulator: path.resolve(__dirname, "..", "..", "core", "simulator", "microbit-simulator-link", "src", "shared"),
}

async function share(src: string, dest: string) {
    await remove(dest)
    await copy(src, dest, {recursive: true})
}


if (require.main === module) {
    (async () => {
        await Promise.all([
            share(src, dests.emergency),
            share(src, dests.simulator),
        ])
    })()
}
