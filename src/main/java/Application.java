
import model.User;
import model.UserRole;
import model.StudyCafe;
import model.Seat;
import controller.SeatController;

public class Application {

    public static void main(String[] args) {
        User user1 = new User("John Doe", UserRole.ADMIN);
        User user2 = new User("Jane Doe", UserRole.BASIC);
        User user3 = new User("John Smith", UserRole.BASIC);

        System.out.println("user1 : " + user1.getId());
        System.out.println("user2 : " + user2.getId());
        System.out.println("user3 : " + user3.getId());
        System.out.println("\n\n");

        StudyCafe studyCafe = new StudyCafe("스터디카페1", 10);
        Seat seat = studyCafe.getSeats().get(0);
//
        for(Seat seats : studyCafe.getSeats()){
            System.out.println("생성 후: " + seats.getId() + " : " + seats.isEmpty() + " : " + seats.getStudyCafe().getName());
        }

        SeatController seatController = new SeatController(seat);
        seatController.reserveSeat(seat.getId()-1);

        System.out.println("\n\n");

        for(Seat seats : studyCafe.getSeats()){
            System.out.println("예약 후: " + seats.getId() + " : " + seats.isEmpty() + " : " + seats.getStudyCafe().getName());
        }

        seatController.changeSeat(0, 1);

        System.out.println("\n\n");


        for(Seat seats : studyCafe.getSeats()){
            System.out.println("변경 후: " + seats.getId() + " : " + seats.isEmpty() + " : " + seats.getStudyCafe().getName());
        }

        seatController.closeSeat(1);

        System.out.println("\n\n");


        for(Seat seats : studyCafe.getSeats()){
            System.out.println("종료 후: " + seats.getId() + " : " + seats.isEmpty() + " : " + seats.getStudyCafe().getName());
        }
    }
}
