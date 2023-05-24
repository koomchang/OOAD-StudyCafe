package view;

import exception.StudyCafeNameException;
import exception.UserRoleException;
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

    public String inputName() {//관리자가 새로운 카페 등록시 받는 Input
        try{
            String name = sc.nextLine();
            validateName(name);
            return name;
        } catch(StudyCafeNameException e){
            System.out.println(e.getMessage());
            return inputName();
        }
    }

    public void askForSeatAmount() {
        System.out.println("스터디카페 총 좌석 수를 입력해주세요.");
    }

    public void showCafeList() {
        System.out.println("스터디카페를 선택해주세요: ");
        StudyCafes.showStudyCafes();
    }

    public String inputCafeName() {//일반 유저가 카페 예약시 받는 input
        try{
            String name = sc.nextLine();
            validateCafeName(name);
            return name;
        } catch(StudyCafeNameException e){
            System.out.println(e.getMessage());
            return inputCafeName();
        }
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

    //StudyCafe name validation
    public void validateName(String name){//관리자가 새로운 카페 등록시 Input validate
        validateExist(name);
        validateAlreadyExist(name);
    }

    public void validateCafeName(String name){//일반 유저가 카페 예약시 input
        validateExist(name);
    }

    public void validateExist(String name){
        if(name.isEmpty()){
            throw new StudyCafeNameException("스터디카페 이름은 공백일 수 없습니다.");
        }
    }

    public void validateAlreadyExist(String name){
        if(StudyCafes.getStudyCafe(name)!=null){
            throw new StudyCafeNameException("이미 존재하는 카페 이름입니다.");
        }
    }

}
