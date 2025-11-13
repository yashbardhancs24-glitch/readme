import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author;
    }
}
class Library {
    private String name;
    private List<Book> books; 

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {
        System.out.println("Books in " + this.name + ":");
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }
}
public class LibraryDemo {
    public static void main(String[] args) {
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen");
        Book book3 = new Book("1984", "George Orwell");
        Library cityLibrary = new Library("City Central Library");
        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);
        cityLibrary.displayBooks();

        System.out.println("\nAn independent book: " + book3);
    }
}
