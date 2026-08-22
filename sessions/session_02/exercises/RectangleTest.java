package chatgpt_lessons.session2;

/**
 * @author snistor
 */
public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle();
        Rectangle rectangle3 = new Rectangle();

        rectangle1.width = 20;
        rectangle1.height = 20;

        rectangle2.width = 10;
        rectangle2.height = 50;

        System.out.println(rectangle1.area());
        System.out.println(rectangle2.area());
        System.out.println(rectangle3.area());

        System.out.println(rectangle1.perimeter());
        System.out.println(rectangle2.perimeter());

        System.out.println(rectangle1.isSquare());
        System.out.println(rectangle2.isSquare());
    }
}
