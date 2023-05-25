package controller;

import model.User;
import model.UserRole;
import view.UserView;

public class UserController {

    private final UserView userView = new UserView();

    public User register() {
        userView.askForName();
        String userName = userView.inputName();
        userView.askForRole();
        UserRole userRole = userView.inputRole();
        User user = new User(userName, userRole);
        user.login();
        userView.printUserInfo(user);
        return user;
    }
}
