import controller.StudyCafeController;
import controller.UserController;
import model.User;

public class Application {

    public static void main(String[] args) {
        UserController userController = new UserController();
        StudyCafeController studyCafeController = new StudyCafeController();
        while (true) {
            User user = userController.register();
            if(user.isAdmin())
                studyCafeController.adminAction(user);
            else
                studyCafeController.userAction(user);
        }

    }
}
