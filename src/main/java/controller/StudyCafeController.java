package controller;

import exception.SeatReservationException;
import model.*;
import view.ReviewView;
import view.StudyCafeView;

public class StudyCafeController {
    private final StudyCafeView studyCafeView = new StudyCafeView();
    private final ReviewView reviewView = new ReviewView();
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
                    reviewView.askForWriteReview();
                    int reviewAction = reviewView.inputAction();
                    switch (reviewAction){
                        case 1:
                            reviewView.askForContent();
                            String content = reviewView.inputReview();
                            Review review = new Review(studyCafe, user, content);
                            Reviews.addReview(review);
                            continue;
                        case 2:
                            continue;
                    }
                    break;
                case 4:
                    reviewView.checkReview();
                    reviewView.showReviewList(studyCafe);
                    continue;
                case 5:
                    user.logout();
                    return;
                default:
                    studyCafeView.wrongInput();
                    break;
            }
        }

    }

}
