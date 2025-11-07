package Exception;
import java.util.*;

//Custom exceptions
class BookNotAvailableException extends Exception {
 public BookNotAvailableException(String message) {
     super(message);
 }
}

class InvalidReturnException extends Exception {
 public InvalidReturnException(String message) {
     super(message);
 }
}

class UserLimitExceededException extends Exception {
 public UserLimitExceededException(String message) {
     super(message);
 }
}

//Library system class
class Library {
 private Map<String, Boolean> books; // book title -> available or not
 private Map<String, List<String>> userBorrowedBooks; // user -> list of borrowed books
 private static final int MAX_BORROW_LIMIT = 5;

 public Library() {
     books = new HashMap<>();
     userBorrowedBooks = new HashMap<>();

     // Sample books, all initially available
     books.put("Java Programming", true);
     books.put("Data Structures", true);
     books.put("Operating Systems", true);
 }

 public void borrowBook(String user, String book) throws BookNotAvailableException, UserLimitExceededException {
     if (!books.containsKey(book)) {
         System.out.println("Logging: Attempt to borrow nonexistent book: " + book);
         throw new BookNotAvailableException("Book not found in library: " + book);
     }

     if (!books.get(book)) { // book not available
         throw new BookNotAvailableException("Book is currently checked out: " + book);
     }

     List<String> borrowedBooks = userBorrowedBooks.getOrDefault(user, new ArrayList<>());
     if (borrowedBooks.size() >= MAX_BORROW_LIMIT) {
         throw new UserLimitExceededException("Borrow limit exceeded (max 5 books). User: " + user);
     }

     borrowedBooks.add(book);
     userBorrowedBooks.put(user, borrowedBooks);
     books.put(book, false); // mark as checked out
     System.out.println(user + " borrowed " + book);
 }

 public void returnBook(String user, String book) throws InvalidReturnException {
     List<String> borrowedBooks = userBorrowedBooks.get(user);

     if (borrowedBooks == null || !borrowedBooks.contains(book)) {
         System.out.println("Logging: Invalid return attempt by " + user + " for book: " + book);
         throw new InvalidReturnException("Book not borrowed by user: " + book);
     }

     borrowedBooks.remove(book);
     if (borrowedBooks.isEmpty()) {
         userBorrowedBooks.remove(user);
     } else {
         userBorrowedBooks.put(user, borrowedBooks);
     }
     books.put(book, true); // mark as available
     System.out.println(user + " returned " + book);
 }
}

//Main class
public class Library_Management_system {
 public static void main(String[] args) {
     Library library = new Library();

     try {
         library.borrowBook("Alice", "Java Programming");
         library.borrowBook("Alice", "Data Structures");
         
         // Simulate user borrowing more than 5 books
         library.borrowBook("Alice", "Operating Systems");
         library.borrowBook("Alice", "Java Programming"); // borrow again to test limit
         library.borrowBook("Alice", "Data Structures");
         library.borrowBook("Alice", "Operating Systems"); 
     } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
     }

     try {
         library.returnBook("Alice", "Java Programming");
         // Return a book not borrowed
         library.returnBook("Alice", "Unknown Book");
     } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}


