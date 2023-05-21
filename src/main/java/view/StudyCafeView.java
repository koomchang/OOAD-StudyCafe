package view;

import java.util.Scanner;

public class StudyCafeView {

    private final Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("스터디카페에 오신 것을 환영합니다!");
    }

    public void printRegister() {
        System.out.println("스터디카페를 등록합니다");
    }

    public void askForName() {
        System.out.println("스터디카페 이름을 입력해주세요.");
    }

    // TODO: input validation
    public String inputName() {
        return sc.nextLine();
    }

    public void askForSeatAmount() {
        System.out.println("스터디카페 총 좌석 수를 입력해주세요.");
    }

    // TODO: input validation
    public int inputSeatAmount() {
        return sc.nextInt();
    }
}
