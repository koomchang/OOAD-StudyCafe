package model;

import java.util.ArrayList;
import java.util.List;
import model.Seat;

public class StudyCafe {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final int seatNumber;
    private final List<Seat> seats;

    public StudyCafe(String name, int seatNumber){
        this.id = nextId++;
        this.name = name;
        this.seatNumber = seatNumber;
        seats = new ArrayList<>();
        for(int i=1; i<=seatNumber; i++){
            seats.add(new Seat(i, true, this));
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getSeatNumber() { return seatNumber; }
    public List<Seat> getSeats() { return seats; }
}
