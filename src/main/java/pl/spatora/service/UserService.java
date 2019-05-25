package pl.spatora.service;

import pl.spatora.dao.UserDaoImpl;

public class UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    public boolean isUserValid(String login, String password) {

        return userDao.getUser(login)
                .map(user -> password.equals(user.getPassword()) && login.equals(user.getLogin()))
                .orElse(false);
    }
}
