package chatgpt_lessons.session3;

/**
 * @author snistor
 */
public class PlayerTest {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.name = "Ana";
        player1.score = 50;

        player2.name = "Bob";
        player2.score = 70;

        Player player3 = player1;
        player3.addScore(40);

        player3 = player2;
        player3.rename("Marley");

        System.out.println(player1.name + " " + player1.score);
        System.out.println(player2.name + " " + player2.score);

        // my prediction for player1.reset() is: Ana 0
        Player.reset(player1);
        System.out.println(player1.name + " " + player1.score);
    }
}
