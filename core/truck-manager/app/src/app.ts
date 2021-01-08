import {$log} from "@tsed/common";
import "@tsed/platform-express"; // /!\ keep this import
import {PlatformExpress} from "@tsed/platform-express";
import {Server} from "./server";
import {Database} from "./database";
import {MovingService} from "./core/services/MovingService";

if (require.main === module) {
    bootstrap()
}


async function bootstrap() {
    try {
        await Database.init();

        $log.debug("Start server...");
        const platform = await PlatformExpress.bootstrap(Server, {});
        await platform.listen();
        setInterval(MovingService.moveTrucks, 3000);
        $log.debug("Server initialized");
    } catch (er) {
        $log.error(er);
    }
}
