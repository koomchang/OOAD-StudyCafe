package controller;

import model.User;
import model.UserRole;
import model.Users;
import view.UserView;

public class UserController {

    private final UserView userView = new UserView();

    public int inputAction(){
        userView.askForAction();
        return userView.inputAction();
    }

    public User login(){
        userView.askForName();
        String name = userView.inputName();
        User user = Users.getUserByName(name);
        if(user == null){
            System.out.println("존재하지 않는 사용자입니다.");
            return login();
        }
        return user;
    }

    public User register() {
        userView.askForName();
        String userName = userView.inputName();
        userView.askForRole();
        UserRole userRole = userView.inputRole();
        User user = new User(userName, userRole);
        Users.addUser(user);
        user.login();
        userView.printUserInfo(user);
        return user;
    }

    public void exit() {
    	System.exit(0);
    }
}
