import model.User;
import model.UserRole;
import view.StudyCafeView;
import view.UserView;

public class Application {

    public static void main(String[] args) {
        StudyCafeView studyCafeView = new StudyCafeView();
        UserView userView = new UserView();
        studyCafeView.start();
        userView.askForUserName();
        String userName = userView.inputUserName();
        userView.askForUserRole();
        UserRole userRole = userView.inputUserRole();
        User user = new User(userName, userRole);
        userView.printUser(user);

//        StudyCafe studyCafe = new StudyCafe("스터디카페1", 10);
//        Seat seat = studyCafe.getSeats().get(0);
////
//        for (Seat seats : studyCafe.getSeats()) {
//            System.out.println("생성 후: " + seats.getId() + " : " + seats.isEmpty() + " : "
//                    + seats.getStudyCafe().getName());
//        }
//
//        SeatController seatController = new SeatController(seat);
//        seatController.reserveSeat(seat.getId() - 1);
//
//        System.out.println("\n\n");
//
//        for (Seat seats : studyCafe.getSeats()) {
//            System.out.println("예약 후: " + seats.getId() + " : " + seats.isEmpty() + " : "
//                    + seats.getStudyCafe().getName());
//        }
//
//        seatController.changeSeat(0, 1);
//
//        System.out.println("\n\n");
//
//        for (Seat seats : studyCafe.getSeats()) {
//            System.out.println("변경 후: " + seats.getId() + " : " + seats.isEmpty() + " : "
//                    + seats.getStudyCafe().getName());
//        }
//
//        seatController.closeSeat(1);
//
//        System.out.println("\n\n");
//
//        for (Seat seats : studyCafe.getSeats()) {
//            System.out.println("종료 후: " + seats.getId() + " : " + seats.isEmpty() + " : "
//                    + seats.getStudyCafe().getName());
    }
}
