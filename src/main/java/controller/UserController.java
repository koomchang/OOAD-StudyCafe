package controller;

import model.User;
import model.UserRole;
import view.UserView;

public class UserController {

    private final UserView userView = new UserView();

    public User login(){
        userView.askForName();
        String name = userView.inputName();
        return new User(name, UserRole.BASIC);
    }

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

    public void exit() {
    	System.exit(0);
    }
}
