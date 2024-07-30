import java.util.Arrays;
import java.util.Comparator;

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
               "bookId='" + bookId + '\'' +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               '}';
    }
}

public class Exercise6 {
    private Book[] books;

    public Exercise6(Book[] books) {
        this.books = books;
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; 
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid]; 
            } else if (comparison < 0) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "1984", "George Orwell"),
            new Book("B003", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B004", "The Catcher in the Rye", "J.D. Salinger")
        };

        
        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        Exercise6 lms = new Exercise6(books);

        System.out.println("Search for '1984' using Linear Search:");
        System.out.println(lms.linearSearchByTitle("1984"));

        System.out.println("\nSearch for 'The Great Gatsby' using Binary Search:");
        System.out.println(lms.binarySearchByTitle("The Great Gatsby"));
    }
}
