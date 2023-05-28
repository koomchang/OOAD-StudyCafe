package view;

import exception.ReviewContentException;
import exception.StudyCafeNameException;
import exception.UserRoleException;
import model.Review;
import model.Reviews;
import model.StudyCafes;

import java.util.Scanner;

public class ReviewView {
    private final Scanner sc = new Scanner(System.in);

    public void askForWriteReview(){
        System.out.println("원하시는 작업을 선택해주세요. (1: 리뷰 작성, 2: 종료)");
    }

    public void checkReview() { System.out.println("작성된 리뷰를 확인합니다.\n"); }

    public void askForContent() {
        System.out.println("리뷰 내용을 입력해주세요.");
    }

    public int inputAction(){
        try{
            String userInput = sc.nextLine();
            validateInputNumeric(userInput);
            return Integer.parseInt(userInput);
        } catch(UserRoleException e){
            System.out.println(e.getMessage());
            return inputAction();
        }
    }

    public String inputReview() {
        try {
            String content = sc.nextLine();
            validateReviewContent(content);
            return content;
        } catch (ReviewContentException e){
            System.out.println(e.getMessage());
            return inputReview();
        }
    }

    public void showReviewList() {
        if(Reviews.reviewIsEmpty()) {
            System.out.println("작성된 리뷰가 없습니다.\n");
        }else {
            Reviews.showReivews();
        }
    }

    public void validateReviewContent(String reviewContent) { validateExist(reviewContent); }
    public void validateExist(String reviewContent){
        if (reviewContent.isEmpty()) {
            throw new ReviewContentException("리뷰 내용은 공백일 수 없습니다.");
        }
    }

    public void validateInputNumeric(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new UserRoleException("숫자만 입력 가능합니다.");
        }
    }
}
