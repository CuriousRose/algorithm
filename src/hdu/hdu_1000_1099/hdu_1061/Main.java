package hdu.hdu_1000_1099.hdu_1061;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int[][] map = {
            {0},
            {1},
            {2, 4, 8, 6},
            {3, 9, 7, 1},
            {4, 6},
            {5},
            {6},
            {7, 9, 3, 1},
            {8, 4, 2, 6},
            {9, 1}
    };

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            int m = n;
            while (m > 10) {
                m %= 10;
            }

            System.out.println(map[m][(n - 1) % map[m].length]);
        }

        scanner.close();

    }
}
