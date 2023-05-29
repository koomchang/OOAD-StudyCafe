package model;

import java.util.ArrayList;

public class StudyCafes {

    private static ArrayList<StudyCafe> studyCafes = new ArrayList<>();

    public static void addStudyCafe(StudyCafe studyCafe) {
        studyCafes.add(studyCafe);
    }

    public static void showStudyCafes() {
        for (StudyCafe studyCafe : studyCafes) {
            System.out.println(studyCafe.getName());
        }
    }

    public static StudyCafe getStudyCafe(String name) {
        return studyCafes.stream()
                .filter(studyCafe -> studyCafe.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static boolean isEmpty() {
        return studyCafes.isEmpty();
    }
}
