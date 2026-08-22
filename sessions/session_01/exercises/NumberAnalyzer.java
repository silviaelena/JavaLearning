package chatgpt_lessons.session1;

/**
 * @author snistor
 */
public class NumberAnalyzer {

    public static void main(String[] args) {
        int[] values = {4, 7, 2, 9, 7, 1};
        int sum = 0;
        int max = values[0];
        int count = 0;

        for (int value : values) {
            System.out.println(value);
            sum += value;
            if (max < value) {
                max = value;
            }
            if (value > 5) {
                count++;
            }
        }
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Greater than 5: " + count);

        boolean x = false;

        if (!x) {
            System.out.println("go");
        }
    }
}
