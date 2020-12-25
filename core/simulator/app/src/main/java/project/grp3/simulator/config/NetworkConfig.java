package project.grp3.simulator.config;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkConfig {
    private final static NetworkConfig instance;

    static {
        instance = new NetworkConfig(
                ConfigurationEntry.fromString(getEnv("MICROBIT_SIMULATOR_LINK_HOST", "http://localhost:8086")),
                ConfigurationEntry.fromString(getEnv("OWN_PORT", "http://localhost:8083"))
        );
    }

    private final ConfigurationEntry microbitSimulatorLink;
    private final ConfigurationEntry own;


    private NetworkConfig(ConfigurationEntry microbitSimulatorLink, ConfigurationEntry own) {
        this.microbitSimulatorLink = microbitSimulatorLink;
        this.own = own;
    }

    public static NetworkConfig getInstance() {
        return instance;
    }

    private static String getEnv(String key, String fallback) {
        if (System.getenv().containsKey(key)) {
            return System.getenv(key);
        }
        return fallback;
    }

    public ConfigurationEntry getMicrobitSimulatorLink() {
        return microbitSimulatorLink;
    }

    public ConfigurationEntry getOwn() {
        return own;
    }


    public static class ConfigurationEntry {
        private final String scheme;
        private final String host;
        private final int port;
        private final String path;


        ConfigurationEntry(String scheme, String host, int port, String path) {
            this.scheme = scheme;
            this.host = host;
            this.port = port;
            this.path = path;
        }

        public static ConfigurationEntry fromString(String in) {

            var pattern = Pattern.compile("(https?)://([a-z.]+)(:[0-9]+)?(.*)");
            final Matcher matcher = pattern.matcher(in);

            var matchs = new ArrayList<String>();

            while (matcher.find()) {
                for (int i = 0; i <= matcher.groupCount(); i++) {
                    matchs.add(matcher.group(i));
                }
            }

            return new ConfigurationEntry(
                    matchs.get(1),
                    matchs.get(2),
                    Integer.parseInt(matchs.get(3) != null ? matchs.get(3).substring(1) : "80"),
                    matchs.get(4)
            );
        }

        public String getScheme() {
            return scheme;
        }

        public String getHost() {
            return host;
        }

        public int getPort() {
            return port;
        }

        public String getPath() {
            return path;
        }


        @Override
        public String toString() {
            return getScheme() + "://" + getHost() + ":" + getPort() + getPath();
        }
    }


}
