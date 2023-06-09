package model;

import java.util.ArrayList;

public class Reviews {
    private static ArrayList<Review> reviews = new ArrayList<>();

    public static void addReview(Review review) {
        reviews.add(review);
    }

    public static boolean reviewIsEmpty() {
        return reviews.isEmpty();
    }
    public static void showReviews(StudyCafe studyCafe) {
        for(Review review : reviews) {
            printReview(review, studyCafe);
        }
    }

    public static void printReview(Review review, StudyCafe studyCafe) {
        if(review.getStudyCafe() == studyCafe)
        {
            System.out.println("작성자 : " + review.getAuthor());
            System.out.println("작성일 : " + review.getCreateDate());
            System.out.println("리뷰 : " + review.getContent());
            System.out.println();
        }

    }
}
