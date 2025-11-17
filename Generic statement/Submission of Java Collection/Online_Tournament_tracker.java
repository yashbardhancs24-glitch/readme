package Collections;
import java.util.*;



//Player class
class Player {
 String name;

 public Player(String name) {
     this.name = name;
 }

 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     Player player = (Player) o;
     return Objects.equals(name, player.name);
 }

 @Override
 public int hashCode() {
     return Objects.hash(name);
 }

 @Override
 public String toString() {
     return name;
 }
}

//Match class
class Match {
 Player player1, player2;

 public Match(Player player1, Player player2) {
     this.player1 = player1;
     this.player2 = player2;
 }

 @Override
 public String toString() {
     return player1 + " vs " + player2;
 }
}

//Result class
class Result {
 Match match;
 Player winner;

 public Result(Match match, Player winner) {
     this.match = match;
     this.winner = winner;
 }

 @Override
 public String toString() {
     return match + " -> Winner: " + winner;
 }
}

//Score class for leaderboard
class Score implements Comparable<Score> {
 Player player;
 int points;

 public Score(Player player, int points) {
     this.player = player;
     this.points = points;
 }

 @Override
 public int compareTo(Score other) {
     // Sort by points descending, then by player name ascending
     if (this.points != other.points) {
         return Integer.compare(other.points, this.points);
     }
     return this.player.name.compareTo(other.player.name);
 }

 @Override
 public String toString() {
     return player.name + ": " + points;
 }
}

//TournamentTracker class
public class Online_Tournament_tracker {
 private Set<Player> players = new HashSet<>();
 private Queue<Match> matchQueue = new LinkedList<>();
 private List<Result> results = new ArrayList<>();
 private TreeSet<Score> leaderboard = new TreeSet<>();

 // Register a player (no duplicates)
 public void registerPlayer(String name) {
     Player player = new Player(name);
     if (players.add(player)) {
         leaderboard.add(new Score(player, 0));
         System.out.println("Player " + name + " registered.");
     } else {
         System.out.println("Player " + name + " already exists.");
     }
 }

 // Schedule a match
 public void scheduleMatch(String name1, String name2) {
     Player p1 = new Player(name1);
     Player p2 = new Player(name2);
     if (!players.contains(p1) || !players.contains(p2)) {
         System.out.println("Both players must be registered.");
         return;
     }
     matchQueue.add(new Match(p1, p2));
     System.out.println("Match scheduled: " + name1 + " vs " + name2);
 }

 // Process the next match
 public void processNextMatch(String winnerName) {
     if (matchQueue.isEmpty()) {
         System.out.println("No matches in queue.");
         return;
     }
     Match match = matchQueue.poll();
     Player winner = new Player(winnerName);
     if (!players.contains(winner)) {
         System.out.println("Winner must be a registered player.");
         return;
     }
     Result result = new Result(match, winner);
     results.add(result);
     // Update leaderboard
     leaderboard.remove(new Score(winner, 0));
     leaderboard.add(new Score(winner, getScore(winner) + 1));
     System.out.println("Match processed: " + result);
 }

 // Get current score for a player
 private int getScore(Player player) {
     for (Score s : leaderboard) {
         if (s.player.equals(player)) {
             return s.points;
         }
     }
     return 0;
 }

 // Display live leaderboard
 public void displayLeaderboard() {
     System.out.println("Leaderboard:");
     for (Score s : leaderboard) {
         System.out.println(s);
     }
 }

 // Display all match results
 public void displayResults() {
     System.out.println("Match Results:");
     for (Result r : results) {
         System.out.println(r);
     }
 }

 // Example usage
 public static void main(String[] args) {
	 Online_Tournament_tracker tracker = new Online_Tournament_tracker();
     tracker.registerPlayer("Alice");
     tracker.registerPlayer("Bob");
     tracker.registerPlayer("Charlie");
     tracker.registerPlayer("Alice"); // Duplicate

     tracker.scheduleMatch("Alice", "Bob");
     tracker.scheduleMatch("Bob", "Charlie");

     tracker.processNextMatch("Alice");
     tracker.processNextMatch("Charlie");

     tracker.displayLeaderboard();
     tracker.displayResults();
 }
}


 

//TournamentTracker class

 