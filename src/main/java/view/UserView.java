package view;

import exception.UserNameException;
import exception.UserRoleException;
import java.util.Scanner;
import model.User;
import model.UserRole;

public class UserView {

    private final Scanner sc = new Scanner(System.in);

    public void askForUserName() {
        System.out.println("환영합니다! 본인의 이름을 입력해주세요.");
    }

    public void askForUserRole() {
        System.out.println("본인의 역할을 입력해주세요. (1: 스터디카페 관리자, 2: 스터디카페 손님)");
    }

    public void printUser(User user) {
        System.out.println("환영합니다! " + user.getName() + "님");
        if (user.isAdmin()) {
            System.out.println("관리자로 로그인하셨습니다.");
        } else {
            System.out.println("손님으로 로그인하셨습니다.");
        }
    }

    public String inputUserName() {
        boolean isUserNameValid = false;
        String userName = null;
        do {
            userName = sc.nextLine();
            try {
                validateUserName(userName);
                isUserNameValid = true;
            } catch (UserNameException e) {
                System.out.println(e.getMessage());
            }
        } while (!isUserNameValid);
        return userName;
    }

    public UserRole inputUserRole() {
        boolean isUserRoleValid = false;
        UserRole userRole = null;
        int userRoleInput = 0;
        do {
            String userInput = sc.nextLine();
            try {
                validateUserRole(userInput);
                userRoleInput = Integer.parseInt(userInput);
                isUserRoleValid = true;
            } catch (UserRoleException e) {
                System.out.println(e.getMessage());
            }
        } while (!isUserRoleValid);
        if (userRoleInput == 1) {
            userRole = UserRole.ADMIN;
        } else if (userRoleInput == 2) {
            userRole = UserRole.BASIC;
        }
        return userRole;
    }

    public void validateUserRole(String userInput) {
        validateInputNumeric(userInput);
        validateUserRoleValue(userInput);
    }

    public void validateUserRoleValue(String userInput) {
        int userRole = Integer.parseInt(userInput);
        if (userRole != 1 && userRole != 2) {
            throw new UserRoleException("1 또는 2를 입력해주세요.");
        }
    }

    public void validateInputNumeric(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new UserRoleException("숫자만 입력 가능합니다.");
        }
    }

    public void validateUserName(String userName) {
        validateExist(userName);
    }

    public void validateExist(String userName) {
        if (userName.isEmpty()) {
            throw new UserNameException("이름은 공백일 수 없습니다");
        }
    }
}
