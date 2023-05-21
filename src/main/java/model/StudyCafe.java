package model;

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

    public void leave(User user) {
        seats.closeSeat(user);
    }
}