package hdu.hdu_1081;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static int[][] map;

    public static void main(String[] args) {

        while (scanner.hasNextInt()) {
            n = scanner.nextInt();

            map = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            run();
        }

        scanner.close();
    }

    static int[][] sum;

    static void run() {
        int max = Integer.MIN_VALUE;

        sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + map[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int b = 0;
                for (int k = 1; k <= n; k++) {
                    int c = sum[k][j] - sum[k][i - 1];
                    b = Math.max(c, b + c);
                    max = Math.max(max, b);
                }
            }
        }

        System.out.println(max);
    }
}