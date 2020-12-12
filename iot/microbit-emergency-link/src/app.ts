import {$log} from "@tsed/common";
import "@tsed/platform-express"; // /!\ keep this import
import {PlatformExpress} from "@tsed/platform-express";
import {Server} from "./server";
import {Uart} from "./shared/uart/Uart";

if (require.main === module) {
    bootstrap()
}


async function bootstrap() {
    try {

        $log.debug("Start server...");
        const platform = await PlatformExpress.bootstrap(Server, {});

        await platform.listen();

        const a = new Uart()
        a.on("serial-input", console.log)

        $log.debug("Server initialized");
    } catch (er) {
        $log.error(er);
    }
}
