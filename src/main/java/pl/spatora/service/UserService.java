package pl.spatora.service;

import pl.spatora.dao.UserDaoImpl;
import pl.spatora.utils.PasswordUtil;

public class UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    public boolean isUserValid(String login, String password) {

        return userDao.getUser(login)
                .map(user ->
                {
                    boolean isPasswordMatch = PasswordUtil.checkPassword(password, user.getPassword());
                    return isPasswordMatch && login.equals(user.getLogin());
                })
                .orElse(false);
    }
}
