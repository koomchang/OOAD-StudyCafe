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
            switch (adminAction) {
                case 1:
                    studyCafeView.printRegister();
                    studyCafeView.askForName();
                    String name = studyCafeView.inputName();
                    studyCafeView.askForSeatAmount();
                    int seatAmount = studyCafeView.inputSeatAmount();
                    StudyCafe studyCafe = new StudyCafe(user, name, seatAmount);
                    StudyCafes.addStudyCafe(studyCafe);
                    break;
                case 2:
                    user.logout();
                    return;
                default:
                    studyCafeView.wrongInput();
                    break;
            }
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
            String cafeName = studyCafeView.inputCafeName();
            try{
                studyCafe = StudyCafes.getStudyCafe(cafeName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            studyCafeView.askForUserAction();
            int userAction = studyCafeView.inputUserAction();
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
