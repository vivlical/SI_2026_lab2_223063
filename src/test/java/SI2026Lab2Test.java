import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    private Library createSampleLibrary() {
        Library library = new Library();
        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "Programming"));
        return library;
    }

    @Test
    public void searchBookEveryStatementTest() {
        Library library = createSampleLibrary();

        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });

        List<Book> found = library.searchBookByTitle("Clean Code");
        assertNotNull(found);
        assertEquals(1, found.size());

        assertNull(library.searchBookByTitle("Non Existing Book"));
    }

    @Test
    public void borrowBookEveryBranchTest() {
        Library library = createSampleLibrary();

        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Robert C. Martin");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Clean Code", "");
        });

        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Non Existing Book", "Unknown");
        });

        library.borrowBook("Clean Code", "Robert C. Martin");
        
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Clean Code", "Robert C. Martin");
        });
    }

    @Test
    public void searchBookMultipleConditionTest() {
        Library library = new Library();
        Book b1 = new Book("Java", "Author", "Tech");
        Book b2 = new Book("Java", "Author", "Tech");
        b2.setBorrowed(true);
        library.addBook(b1);
        library.addBook(b2);

        assertNotNull(library.searchBookByTitle("Java"));
        assertNull(library.searchBookByTitle("Python"));
    }

    @Test
    public void borrowBookMultipleConditionTest() {
        Library library = createSampleLibrary();

        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Author");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Title", "");
        });

        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Title", "Author");
        });
    }
}