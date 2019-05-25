package pl.spatora.dao;

import pl.spatora.model.User;
import pl.spatora.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public Optional<User> getUser(String login) {

        User user = new User();
        String selectSQL = "SELECT * FROM users where login = ?";

        try (Connection dbConnection = DBConnection.getInstance().getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                Long userId = rs.getLong("id");
                String userLogin = rs.getString("login");
                String userPassword = rs.getString("password");

               return Optional.of(new User(userId, userLogin, userPassword));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

}
