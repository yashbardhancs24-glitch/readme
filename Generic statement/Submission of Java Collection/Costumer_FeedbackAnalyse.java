package Collections;
import java.util.*;

public class Costumer_FeedbackAnalyse {
    List<String> allFeedbacks = new ArrayList<>();
    Set<String> uniqueFeedbacks = new HashSet<>();
    Queue<String> feedbackQueue = new LinkedList<>();
    Stack<String> recentFeedbacks = new Stack<>();

    public void addFeedback(String feedback) {
        allFeedbacks.add(feedback);
    }

    public void processFeedbacks() {
        for (String feedback : allFeedbacks) {
            if (uniqueFeedbacks.add(feedback)) {
                feedbackQueue.add(feedback);
            }
        }
        while (!feedbackQueue.isEmpty()) {
            String feedback = feedbackQueue.poll();
            recentFeedbacks.push(feedback);
        }
    }

    public void displayRecentFeedbacks(int count) {
        System.out.println("Last " + count + " feedbacks:");
        int displayed = 0;
        for (int i = recentFeedbacks.size() - 1; i >= 0 && displayed < count; i--, displayed++) {
            System.out.println(recentFeedbacks.get(i));
        }
    }

    public static void main(String[] args) {
    	Costumer_FeedbackAnalyse system = new Costumer_FeedbackAnalyse();

        system.addFeedback("Great product");
        system.addFeedback("Fast delivery");
        system.addFeedback("Great product");
        system.addFeedback("Excellent customer service");
        system.addFeedback("Fast delivery");

        system.processFeedbacks();

        system.displayRecentFeedbacks(3);
    }
}


