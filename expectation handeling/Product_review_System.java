package Exception;
//Custom exceptions for invalid rating and empty review
class InvalidRatingException extends Exception {
 public InvalidRatingException(String message) {
     super(message);
 }
}

class EmptyReviewException extends Exception {
 public EmptyReviewException(String message) {
     super(message);
 }
}

//Product review class
class ProductReview {
 public void submitReview(int rating, String comment) throws InvalidRatingException, EmptyReviewException {
     if (rating < 1 || rating > 5) {
         throw new InvalidRatingException("Rating must be between 1 and 5.");
     }
     if (comment == null || comment.trim().isEmpty()) {
         throw new EmptyReviewException("Review comment cannot be empty.");
     }
     System.out.println("Review submitted successfully: Rating=" + rating + ", Comment=\"" + comment + "\"");
 }
}

//Main class
public class Product_review_System {
 public static void main(String[] args) {
     ProductReview review = new ProductReview();

     try {
         review.submitReview(6, "Good product!"); // Invalid rating
     } catch (InvalidRatingException e) {
         System.out.println("Error: " + e.getMessage());
     } catch (EmptyReviewException e) {
         System.out.println("Error: " + e.getMessage());
     }

     try {
         review.submitReview(4, ""); // Empty comment
     } catch (InvalidRatingException e) {
         System.out.println("Error: " + e.getMessage());
     } catch (EmptyReviewException e) {
         System.out.println("Error: " + e.getMessage());
     }

     try {
         review.submitReview(5, "Excellent quality!"); // Valid review
     } catch (InvalidRatingException | EmptyReviewException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}


