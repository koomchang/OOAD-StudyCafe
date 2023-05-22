import controller.StudyCafeController;
import controller.UserController;
import model.User;

public class Application {

    public static void main(String[] args) {
        UserController userController = new UserController();
        StudyCafeController studyCafeController = new StudyCafeController();
        User user = userController.register();
        studyCafeController.register(user);
    }
}
