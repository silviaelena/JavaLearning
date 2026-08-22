package chatgpt_lessons.session3;

/**
 * @author snistor
 */
public class Book {
    String title;
    int pages;

    public void addPages(int amount) {
        this.pages += amount;
    }

    public static void replace(Book b) {
        b.pages = 0;
        b = new Book();
        b.pages = 999;
    }
}
