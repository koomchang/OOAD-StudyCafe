package model;

import exception.SeatReservationException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seats {

    private final List<Seat> seats;

    public Seats(int seatNumber) {
        this.seats = IntStream.range(1, seatNumber + 1)
                .mapToObj(i -> new Seat(i, null))
                .collect(Collectors.toList());
    }

    public Seat getSeatBySeatNumber(int seatNumber) {
        return seats.stream()
                .filter(seat -> seat.getSeatNumber() == seatNumber)
                .findFirst()
                .orElse(null);
    }

    public Seat getSeatByUser(User user){
        return seats.stream()
                .filter(seat -> seat.getUser().equals(user))
                .findFirst()
                .orElseThrow(() -> new SeatReservationException("아직 좌석 예약을 하지 않으셨습니다"));
    }

    //
    public void closeSeat(User user) {
        Seat closingSeat = seats.stream()
                .filter(seat -> seat.getUser().equals(user))
                .findFirst()
                .orElseThrow(() -> new SeatReservationException("아직 좌석 예약을 하지 않으셨습니다"));
        closingSeat.removeSeatFromUser(user);
    }

    public boolean isSeatEmpty(int seatNumber){
        return getSeatBySeatNumber(seatNumber).isEmpty();
    }
}
