package controller;

import model.User;
import view.StudyCafeView;

public class StudyCafeController {

    private final StudyCafeView studyCafeView = new StudyCafeView();

    public void register(User user) {
        if (user.isAdmin()) {
            studyCafeView.printRegister();
            studyCafeView.askForName();
            studyCafeView.inputName();
            studyCafeView.askForSeatAmount();
            studyCafeView.inputSeatAmount();
        }
    }
}
