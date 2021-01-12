import {$log} from "@tsed/common";
import "@tsed/platform-express"; // /!\ keep this import
import {PlatformExpress} from "@tsed/platform-express";
import {Server} from "./server";
import {Services} from "./core/services";

if (require.main === module) {
    bootstrap()
}


async function bootstrap() {
    try {
        $log.debug("Start server...");
        Services.fire();
        const platform = await PlatformExpress.bootstrap(Server, {});
        await platform.listen();

        $log.debug("Server initialized");
    } catch (er) {
        $log.error(er);
    }
}
