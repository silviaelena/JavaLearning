package chatgpt_lessons.session3;

/**
 * @author snistor
 */
public class Player {
    String name;
    int score;

    public void addScore(int amount) {
        this.score += amount;
    }

    public void rename(String newName) {
        this.name = newName;
    }

    public static void reset(Player p) {
        p.score = 0;
        p = new Player();
        p.score = 999;
    }
}
