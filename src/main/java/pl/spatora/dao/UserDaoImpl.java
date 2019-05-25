package pl.spatora.dao;

import pl.spatora.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/warehouse?serverTimezone=GMT&useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "afEq19eKSmWTl72yMcKx";


    @Override
    public Optional<User> getUser(String login) {
        return Optional.empty();
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return dbConnection;
    }
}
