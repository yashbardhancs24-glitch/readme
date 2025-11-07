package Exception;
import java.util.*;
import java.util.Scanner;

//Custom exception class
class InvalidCredentialsException extends Exception {
 public InvalidCredentialsException(String message) {
     super(message);
 }
}

//Login class with validate method
class Login {
 private final String validUsername = "admin";
 private final String validPassword = "password123";

 public void validate(String user, String pass) throws InvalidCredentialsException {
     if (!user.equals(validUsername) || !pass.equals(validPassword)) {
         throw new InvalidCredentialsException("Invalid username or password.");
     }
 }
}

//Main class to simulate login process
public class Login_System {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Login login = new Login();

     while (true) {
         System.out.print("Enter username: ");
         String username = scanner.nextLine();

         System.out.print("Enter password: ");
         String password = scanner.nextLine();

         try {
             login.validate(username, password);
             System.out.println("Login successful!");
             break; // Exit loop if login succeeds
         } catch (InvalidCredentialsException e) {
             System.out.println(e.getMessage() + " Please try again.");
         }
     }

     scanner.close();
 }
}


