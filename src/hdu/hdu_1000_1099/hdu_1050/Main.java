package hdu.hdu_1000_1099.hdu_1050;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int t;
    static int n;

    static int[][] map;
    static int[] cm;

    public static void main(String[] args) {
        t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();

            map = new int[n][2];

            for (int j = 0; j < n; j++) {
                map[j][0] = (scanner.nextInt() + 1) / 2;
                map[j][1] = (scanner.nextInt() + 1) / 2;
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        cm = new int[200 + 1];

        for (int i = 0; i < n; i++) {
            int l = Math.min(map[i][0], map[i][1]);
            int r = Math.max(map[i][0], map[i][1]);

            for (int j = l; j <= r; j++) {
                cm[j]++;
            }
        }

        int max = 0;
        for (int i = 1; i <= 200; i++) {
            max = Math.max(max, cm[i]);
        }

        System.out.println(max * 10);
    }
}
