package Chapter13;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 1000; i++ ) {
        System.out.println(rand.nextInt(50));
        }
    }
}