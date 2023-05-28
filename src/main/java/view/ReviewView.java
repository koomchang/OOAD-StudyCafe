package view;

import exception.ReviewContentException;
import model.Review;
import java.util.Scanner;

public class ReviewView {
    private final Scanner sc = new Scanner(System.in);

    public void askForWriteReview(){
        System.out.println("원하시는 작업을 선택해주세요. (1: 리뷰 작성, 2: 종료)");
    }

    public void reviewWriteComment(){
        System.out.println("리뷰를 작성합니다.");
    }

    public void askForContent() {
        System.out.println("리뷰 내용을 입력해주세요.");
    }


    public String inputReview() {
        String content = sc.nextLine();
        return content;
    }

    public void printReview(Review review) {
        System.out.println("리뷰 번호 " + review.getReviewId() + "번");
        System.out.println("작성자 : " + review.getAuthor());
        System.out.println("작성일 : " + review.getCreateDate());
        System.out.println("리뷰 : " + review.getContent() );
    }

    public void validateReviewContent(String reviewContent) { validateExist(reviewContent); }
    public void validateExist(String reviewContent){
        if (reviewContent.isEmpty()) {
            throw new ReviewContentException("리뷰 내용은 공백일 수 없습니다.");
        }
    }
}
