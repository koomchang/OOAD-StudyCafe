package model;

import exception.SeatReservationException;

public class Seat {

    private final int seatNumber;
    private User user;
    private boolean empty;

    public Seat(int seatNumber, User user) {
        this.seatNumber = seatNumber;
        this.user = user;
        this.empty = user == null;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public User getUser() {
        return user;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void assignSeatToUser(User user) {
        if (this.isEmpty()) {
            this.user = user;
            this.empty = false;
        } else {
            throw new SeatReservationException("이미 예약된 자리입니다.");
        }
    }

    public void removeSeatFromUser(User user) {
        if (this.user.equals(user)) {
            this.user = null;
            this.empty = true;
        } else {
            throw new SeatReservationException("예약하신 자리가 존재하지 않습니다.");
        }
    }
}
