package controller;

import model.StudyCafe;
import model.StudyCafes;
import model.User;
import view.StudyCafeView;

public class StudyCafeController {

    private final StudyCafeView studyCafeView = new StudyCafeView();

    private StudyCafe studyCafe;
    // 임의로 설정 해놓음

    public void register(User user) {
        if (user.isAdmin()) {
            studyCafeView.printRegister();
            studyCafeView.askForName();
            String name = studyCafeView.inputName();
            studyCafeView.askForSeatAmount();
            int seatAmount = studyCafeView.inputSeatAmount();
            StudyCafe studyCafe1 = new StudyCafe(user, name, seatAmount);
            StudyCafes.addStudyCafe(studyCafe1);
            // prototype: 코드 확인용
            // TODO: 추후 수정 필요
        } else {
            studyCafeView.showCafeList();
            String cafeName = studyCafeView.inputCafeName();
            studyCafe = StudyCafes.getStudyCafe(cafeName);
            studyCafeView.showSeatList(studyCafe);
            studyCafeView.askForUserAction();
            studyCafeView.inputUserAction();
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
