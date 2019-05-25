package pl.spatora.dao;

import pl.spatora.model.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUser(String login);
}
