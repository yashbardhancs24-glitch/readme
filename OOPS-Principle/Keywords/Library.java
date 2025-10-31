package Keywords;

class Book1 {
    private static String libraryName;
    private String title;
    private String author;
    private final String isbn;

    public Book1(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    Book1(String isbn) {
        this.isbn = isbn;
    }

    public Book1(String effectiveJava, String joshuaBloch, String s, String isbn) {
        this.isbn = isbn;
    }

    public static void setLibraryName(String name) { libraryName = name; }
    public static void displayLibraryName() { System.out.println("Library Name: " + libraryName); }

    public void displayBookDetails() {
        if (this instanceof Book1) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
}

public class Library {
    public static void main(String[] args) {
        Book1.setLibraryName("Egmore Library");
        Book1.displayLibraryName();
        Book1 book1 = new Book1("Effective Java","Joshua Bloch","978-0134685991");
        book1.displayBookDetails();
    }
}
