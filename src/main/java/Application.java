import model.User;
import model.UserRole;

public class Application {

    public static void main(String[] args) {
        User user1 = new User("John Doe", UserRole.ADMIN);
        User user2 = new User("Jane Doe", UserRole.BASIC);
        User user3 = new User("John Smith", UserRole.BASIC);

        System.out.println("user1 : " + user1.getId());
        System.out.println("user2 : " + user2.getId());
        System.out.println("user3 : " + user3.getId());
    }
}
