package model;

import exception.StudyCafeNameException;

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
        StudyCafe cafe = studyCafes.stream()
                .filter(studyCafe -> studyCafe.getName().equals(name))
                .findFirst()
                .orElse(null);
        if(cafe == null){
            throw new StudyCafeNameException("해당 이름의 스터디카페가 존재하지 않습니다.");
        }
        return cafe;
    }
}
