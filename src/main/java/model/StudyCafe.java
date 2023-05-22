package model;

import exception.SeatReservationException;

public class StudyCafe {

    private final User admin;
    private final String name;
    private final int seatAmount;
    private final Seats seats;

    public StudyCafe(User admin, String name, int seatAmount) {
        this.admin = admin;
        this.name = name;
        this.seatAmount = seatAmount;
        this.seats = new Seats(seatAmount);
    }

    public User getAdmin() {
        return admin;
    }

    public String getName() {
        return name;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public Seats getSeats() {
        return seats;
    }

    public Seat reserve(int seatNumber, User user) {
        Seat seat = seats.getSeatBySeatNumber(seatNumber);
        seat.assignSeatToUser(user);
        return seat;
    }

    public Seat changeSeat(int newSeatNumber, User user) {
        Seat originalSeat = seats.getSeatByUser(user);

        if(originalSeat.getSeatNumber() == newSeatNumber){
            throw new SeatReservationException("같은 자리를 선택하셨습니다.");
        }
        if(!seats.isSeatEmpty(newSeatNumber)){
            throw new SeatReservationException("이미 예약된 자리입니다.");
        }
        seats.closeSeat(user);

        Seat newSeat = seats.getSeatBySeatNumber(newSeatNumber);
        newSeat.assignSeatToUser(user);
        return newSeat;
    }

    public void leave(User user) {
        seats.closeSeat(user);
    }
}