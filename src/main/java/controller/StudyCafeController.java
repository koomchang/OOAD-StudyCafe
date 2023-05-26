package controller;

import model.StudyCafe;
import model.StudyCafes;
import model.User;
import view.StudyCafeView;

public class StudyCafeController {

    private final StudyCafeView studyCafeView = new StudyCafeView();
    private StudyCafe studyCafe;

    public void adminAction(User user) {
        while (true) {
            studyCafeView.askForAdminAction();
            int adminAction = studyCafeView.inputAdminAction();
            if(adminAction == 2){
                user.logout();
                return;
            }
            studyCafeView.printRegister();
            studyCafeView.askForName();
            String name = studyCafeView.inputName();
            studyCafeView.askForSeatAmount();
            int seatAmount = studyCafeView.inputSeatAmount();
            StudyCafe studyCafe1 = new StudyCafe(user, name, seatAmount);
            StudyCafes.addStudyCafe(studyCafe1);
            // prototype: 코드 확인용
            // TODO: 추후 수정 필요
        }
    }

    public void userAction(User user){
        studyCafeView.start();
        while(true){
            studyCafeView.askForInitialUserAction();
            int initialUserAction = studyCafeView.inputInitialUserAction();
            switch(initialUserAction){
                case 1:
                    studyCafeView.showCafeList();
                    break;
                case 2:
                    user.logout();
                    return;
                default:
                    studyCafeView.wrongInput();
                    break;
            }
            studyCafeView.askForUserAction();
            int userAction = studyCafeView.inputUserAction();
            String cafeName = studyCafeView.inputCafeName();
            studyCafe = StudyCafes.getStudyCafe(cafeName);
            switch(userAction){
                case 1:
                    studyCafeView.showSeatList(studyCafe);
                    studyCafe.reserve(studyCafeView.inputSeatNumber(), user);
                    break;
                case 2:
                    studyCafeView.showSeatList(studyCafe);
                    studyCafe.changeSeat(studyCafeView.inputSeatNumber(), user);
                    studyCafeView.changeSeatComment();
                    break;
                case 3:
                    studyCafe.leave(user);
                    studyCafeView.leaveComment();
                    break;
                case 4:
                    user.logout();
                    return;
                default:
                    studyCafeView.wrongInput();
                    break;
            }
        }

    }

}
