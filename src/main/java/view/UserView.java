package view;

import exception.UserNameException;
import exception.UserRoleException;
import java.util.Scanner;
import model.User;
import model.UserRole;

public class UserView {

    private final Scanner sc = new Scanner(System.in);

    public void askForName() {
        System.out.println("환영합니다! 본인의 이름을 입력해주세요.");
    }

    public void askForRole() {
        System.out.println("본인의 역할을 입력해주세요. (1: 스터디카페 관리자, 2: 스터디카페 손님)");
    }

    public void printUserInfo(User user) {
        System.out.println("환영합니다! " + user.getName() + "님");
        if (user.isAdmin()) {
            System.out.println("관리자로 로그인하셨습니다.");
        } else {
            System.out.println("손님으로 로그인하셨습니다.");
        }
    }

    public String inputName() {
        try {
            String userName = sc.nextLine();
            validateUserName(userName);
            return userName;
        } catch (UserNameException e) {
            System.out.println(e.getMessage());
            return inputName();
        }
    }

    public UserRole inputRole() {
        try {
            String userInput = sc.nextLine();
            validateUserRole(userInput);
            int roleNumber = Integer.parseInt(userInput);
            return UserRole.of(roleNumber);
        } catch (UserRoleException e) {
            System.out.println(e.getMessage());
            return inputRole();
        }
    }

    public void validateUserRole(String userInput) {
        validateInputNumeric(userInput);
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
