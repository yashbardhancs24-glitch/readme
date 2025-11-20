package map_interface;

import java.util.*;

public class VotingCounter {
    public static void main(String[] args) {

        Map<String, Integer> votes = new HashMap<>();

        String[] castedVotes = {
            "Alice", "Bob", "Alice", "Charlie", "Bob",
            "Alice", "Charlie", "Alice", "Bob", "Alice"
        };

        for (String candidate : castedVotes) {
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        }

        System.out.println("Vote Count:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes");
    }
}
