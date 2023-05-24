package model;

import java.util.ArrayList;

public class StudyCafes {

    private static ArrayList<StudyCafe> studyCafes = new ArrayList<>();

    public static void addStudyCafe(StudyCafe studyCafe) {
        studyCafes.add(studyCafe);
    }
}
