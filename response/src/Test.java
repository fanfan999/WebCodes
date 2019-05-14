import java.util.Random;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Random rand = new Random();
            int j = rand.nextInt(5);
            System.out.println(j);
        }
    }
}
