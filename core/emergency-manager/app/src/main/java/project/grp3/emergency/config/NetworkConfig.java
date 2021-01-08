package project.grp3.emergency.config;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkConfig
{
    private final static NetworkConfig instance;

    static
    {
        instance = new NetworkConfig(
                new DatabaseEntry(
                        getEnv("DATABASE_URL", "localhost"),
                        getEnv("DATABASE_PORT", "5434"),
                        getEnv("DATABASE_PASSWORD", "example"),
                        getEnv("DATABASE_USER", "postgres"),
                        getEnv("DATABASE_DATABASE", "postgres")
                ),
                ConfigurationEntry.fromString(getEnv("TRUCK_SERVER_HOST", "http://localhost:8085")),
                ConfigurationEntry.fromString(getEnv("OWN_HOST", "http://localhost:8084"))
        );
    }

    private final DatabaseEntry database;
    private final ConfigurationEntry truckApp;
    private final ConfigurationEntry self;

    private NetworkConfig(DatabaseEntry database, ConfigurationEntry truckServer, ConfigurationEntry self)
    {
        this.database = database;
        this.truckApp = truckServer;
        this.self = self;
    }

    public static NetworkConfig getInstance()
    {
        return instance;
    }

    private static String getEnv(String key, String fallback)
    {
        if (System.getenv().containsKey(key))
        {
            return System.getenv(key);
        }
        return fallback;
    }

    public ConfigurationEntry getTruckApp()
    {
        return truckApp;
    }

    public ConfigurationEntry getSelf()
    {
        return self;
    }

    public DatabaseEntry getDatabase()
    {
        return database;
    }


    public static class ConfigurationEntry
    {
        private final String scheme;
        private final String host;
        private final int port;


        ConfigurationEntry(String scheme, String host, int port)
        {
            this.scheme = scheme;
            this.host = host;
            this.port = port;
        }

        public static ConfigurationEntry fromString(String in)
        {
            var pattern = Pattern.compile("^(?:((?:https?|s?ftp))://)([^:/\\s]+)(?::(\\d*))?(?:/([^\\s?#]+)?([?][^?#]*)?(#.*)?)?");
            final Matcher matcher = pattern.matcher(in);

            var matchs = new ArrayList<String>();

            while (matcher.find())
            {
                for (int i = 0; i <= matcher.groupCount(); i++)
                {
                    matchs.add(matcher.group(i));
                }
            }

            return new ConfigurationEntry(
                    matchs.get(1),
                    matchs.get(2),
                    Integer.parseInt(matchs.get(3))
            );
        }

        public String getScheme()
        {
            return scheme;
        }

        public String getHost()
        {
            return host;
        }

        public int getPort()
        {
            return port;
        }



        @Override
        public String toString()
        {
            return getScheme() + "://" + getHost() + ":" + getPort();
        }
    }


    public static class DatabaseEntry
    {
        private final String url;
        private final String password;
        private final String user;
        private final String database;
        private final String port;


        public DatabaseEntry(String url, String port, String password, String user, String database)
        {
            this.url = url;
            this.port = port;
            this.password = password;
            this.user = user;
            this.database = database;
        }

        public String getUrl()
        {
            return url;
        }

        public String getPassword()
        {
            return password;
        }

        public String getUser()
        {
            return user;
        }

        public String getDatabase()
        {
            return database;
        }

        @Override
        public String toString()
        {
            return "jdbc:postgresql://%s:%s/%s".formatted(url, port, database);
        }
    }


}
