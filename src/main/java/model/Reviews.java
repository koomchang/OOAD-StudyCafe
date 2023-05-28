package model;

import java.util.ArrayList;

public class Reviews {
    private static ArrayList<Review> reviews = new ArrayList<>();

    public static void addUser(Review review) {
        reviews.add(review);
    }

    public static Review getReviewByUser(User user){
        return reviews.stream()
                .filter(review -> review.getAuthor().equals(user))
                .findFirst()
                .orElse(null);
    }
}
