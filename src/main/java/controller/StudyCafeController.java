package controller;

import exception.SeatReservationException;
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
            studyCafe = StudyCafes.getStudyCafe(cafeName);
            if(studyCafe == null){
                System.out.println("해당 이름의 스터디카페가 존재하지 않습니다.");
                continue;
            }

            studyCafeView.askForUserAction();
            int userAction = studyCafeView.inputUserAction();
            switch(userAction){
                case 1:
                    studyCafeView.showSeatList(studyCafe);
                    try{
                        studyCafe.reserve(studyCafeView.inputSeatNumber(), user);
                    } catch(SeatReservationException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                case 2:
                    studyCafeView.showSeatList(studyCafe);
                    try{
                        studyCafe.changeSeat(studyCafeView.inputSeatNumber(), user);
                    } catch(SeatReservationException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
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
