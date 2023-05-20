package model;
import model.StudyCafe;

public class Seat {
    private int id; //스터디카페별 좌석 id
    private boolean empty;
    private StudyCafe studyCafe;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setStudyCafe(StudyCafe studyCafe) {
        this.studyCafe = studyCafe;
    }

    public Seat(int id, boolean empty, StudyCafe studyCafe){
        this.id = id;
        this.empty = empty;
        this.studyCafe = studyCafe;
    }

    public int getId() { return id; }
    public boolean isEmpty() { return empty; }
    public StudyCafe getStudyCafe() { return studyCafe;}
}
