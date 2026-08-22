package session_03.exercises;

import java.util.Arrays;

/**
 * @author snistor
 */
public class BookTest {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();

        book1.title = "Mizerabilii";
        book1.pages = 1000;

        book2.title = "Falsificatorii de bani";
        book2.pages = 500;

        Book book3 = book1;
        book3.addPages(100);

        book3 = book2;
        book3.title = "Kokoro";

        Book[] library = new Book[3];
        library[0] = book1;
        library[1] = book2;
        library[2] = book1;

        for (Book book : library) {
            System.out.println("Book: " + book.title + " book pages: " + book.pages);
        }

        // prediction: 0
        Book.replace(book1);
        System.out.println(book1.pages);
    }
}
