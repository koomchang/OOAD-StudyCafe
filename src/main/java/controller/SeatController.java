package controller;
import model.Seat;
import model.StudyCafe;

public class SeatController {
    private Seat seat;

    public SeatController(Seat seat){
        this.seat = seat;
    }

    // 자리 예약
    public void reserveSeat(int seatId){
        seat.getStudyCafe().getSeats().get(seatId).setEmpty(false);
    }

    // 사용 종료
    public void closeSeat(int seatId){
        seat.getStudyCafe().getSeats().get(seatId).setEmpty(true);
    }

    // 자리 변경
    public void changeSeat(int orginalSeatId, int newSeatId){
        if(seat.getStudyCafe().getSeats().get(newSeatId).isEmpty()){
            seat.getStudyCafe().getSeats().get(orginalSeatId).setEmpty(true);
            seat.getStudyCafe().getSeats().get(newSeatId).setEmpty(false);
            return;
        }
        System.out.println("이미 예약된 자리입니다.");
    }

}
