import controller.StudyCafeController;
import controller.UserController;
import model.User;

public class Application {

    public static void main(String[] args) {
        UserController userController = new UserController();
        StudyCafeController studyCafeController = new StudyCafeController();
        User user = userController.register();
        studyCafeController.register(user);

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
