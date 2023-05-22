package controller;

import model.StudyCafe;
import model.User;
import view.StudyCafeView;

public class StudyCafeController {

    private final StudyCafeView studyCafeView = new StudyCafeView();

    // TODO: studyCafe를 Seats 처럼 여러개 담을수 있 class 따로 구성?
    private final StudyCafe studyCafe = new StudyCafe(null, "dasdas", 20);
    // 임의로 설정 해놓음

    public void register(User user) {
        if (user.isAdmin()) {
            studyCafeView.printRegister();
            studyCafeView.askForName();
            studyCafeView.inputName();
            studyCafeView.askForSeatAmount();
            studyCafeView.inputSeatAmount();

        // prototype: 코드 확인용
        // TODO: 추후 수정 필요
        } else {
            studyCafeView.showCafeList();
            studyCafeView.inputCafeNumber();
            studyCafeView.showSeatList(studyCafe);
            studyCafeView.askForAction();
            studyCafeView.inputAction();
            studyCafe.reserve(studyCafeView.inputSeatNumber(), user);
            studyCafeView.showSeatList(studyCafe);
            studyCafe.changeSeat(studyCafeView.inputSeatNumber(), user);
            studyCafeView.changeSeatComment();
            studyCafeView.showSeatList(studyCafe);
            studyCafe.leave(user);
            studyCafeView.leaveComment();
            studyCafeView.showSeatList(studyCafe);
        }
    }

}
