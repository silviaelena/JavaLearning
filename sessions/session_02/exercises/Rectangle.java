package session_02.exercises;

/**
 * @author snistor
 */
public class Rectangle {
    double width;
    double height;

    public double area() {
        return height * width;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }
}
