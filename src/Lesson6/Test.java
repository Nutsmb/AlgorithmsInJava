package Lesson6;

import java.util.Random;

public class Test {
    public static void main(String[] args) {

        int balanced = 0;
        Random random = new Random();
        Trees<Integer, String>[] treeMaps = new Trees[100000];
        for (int i = 0; i < treeMaps.length; i++) {
            treeMaps[i] = new Trees<>();
            while (treeMaps[i].height() < 5) {
                treeMaps[i].put(random.nextInt(200) , "");
            }
            if (treeMaps[i].isBalance()) {
                balanced++;
            }
        }
        System.out.println("\n" + balanced);
    }
}
