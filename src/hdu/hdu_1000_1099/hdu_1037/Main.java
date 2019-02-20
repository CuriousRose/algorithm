package hdu.hdu_1000_1099.hdu_1037;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] l = new int[3];

        for (int i = 0; i < 3; i++) {
            l[i] = scanner.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            if (l[i] <= 168) {
                System.out.println(String.format("CRASH %d", l[i]));
                return;
            }
        }

        System.out.println("NO CRASH");

        scanner.close();
    }
}
