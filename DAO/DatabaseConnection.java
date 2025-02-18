package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    public static Connection getConnection() {

        try {
            Properties prop = getProperties();
            final String stringConnection = prop.getProperty("db.url");
            final String username = prop.getProperty("db.username");
            final String password = prop.getProperty("db.password");

            try {
                Connection c = DriverManager
                        .getConnection(stringConnection, username, password);
                System.out.println("Conectado com sucesso!");
                return c;

            } catch (SQLException e) {
                System.out.println("Error ao tentar estabelecer conexao! " + e.getMessage());
                return null;

            }
        } catch (IOException f) {
            System.out.println("Erro ao carregar o arquivo! " + f.getMessage());
            return null;
        }
    }

    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String path = "/db.properties";
        prop.load(DatabaseConnection.class.getResourceAsStream(path));
        return prop;
    }
}
