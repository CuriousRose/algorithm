package hdu.hdu_1000_1099.hdu_1064;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double t = 0;
        for (int i = 0; i < 12; i++) {
            t += scanner.nextDouble();
        }

        System.out.println(String.format("$%.2f", t / 12));
        scanner.close();
    }
}
