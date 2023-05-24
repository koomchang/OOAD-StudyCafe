package view;

import model.StudyCafe;
import model.StudyCafes;

import java.util.Scanner;

import model.StudyCafes;

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

    public void showCafeList() {
        System.out.println("스터디카페를 선택해주세요: ");
        StudyCafes.showStudyCafes();
    }

    // TODO: input validation
    public String inputCafeName() {
        return sc.nextLine();
    }

    // TODO: input validation
    public int inputSeatAmount() {
        return sc.nextInt();
    }

    public void showSeatList(StudyCafe studyCafe){
        studyCafe.showSeats();
    }

    public void askForAdminAction(){
        System.out.println("원하시는 작업을 선택해주세요: ");
        System.out.println("1. 스터디카페 등록");
        System.out.println("2. 로그아웃");
    }

    // TODO: input validation
    public int inputAdminAction(){
        return sc.nextInt();
    }

    public void askForUserAction(){
        System.out.println("원하시는 작업을 선택해주세요: ");
        System.out.println("1. 좌석 예약");
        System.out.println("2. 좌석 변경");
        System.out.println("3. 좌석 이용 종료");
        System.out.println("4. 로그아웃");
        // TODO: 다른 작업 추가
    }

    // TODO: input validation
    public int inputUserAction(){
        return sc.nextInt();
    }

    // TODO: input validation
    public int inputSeatNumber(){
        System.out.println("원하시는 좌석 번호를 입력해주세요: ");
        return sc.nextInt();
    }

    public void leaveComment(){
        System.out.println("\n좌석 이용을 종료하셨습니다.\n");
    }

    public void changeSeatComment(){
        System.out.println("\n좌석을 변경하셨습니다.\n");
    }

}
