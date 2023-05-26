import controller.StudyCafeController;
import controller.UserController;
import model.User;

public class Application {

    private static int initialAction;

    public static void main(String[] args) {
        UserController userController = new UserController();
        StudyCafeController studyCafeController = new StudyCafeController();
        User user = new User("guest", null);
        while (true) {
            initialAction = userController.inputAction();
            switch(initialAction){
                case 1:
                    user = userController.login();
                    break;
                case 2:
                    user = userController.register();
                    break;
                case 3:
                    userController.exit();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    continue;
            }
            if(user.isAdmin()){
                studyCafeController.adminAction(user);
                continue;
            }
            studyCafeController.userAction(user);
        }

    }
}
