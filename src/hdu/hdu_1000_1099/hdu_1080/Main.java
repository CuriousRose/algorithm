package hdu.hdu_1000_1099.hdu_1080;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int[][] map = {
            {5, -1, -2, -1, -3},
            {-1, 5, -3, -2, -4},
            {-2, -3, 5, -2, -2},
            {-1, -2, -2, 5, -1},
            {-3, -4, -2, -1, 0}
    };

    static int l1;
    static int l2;

    static int s1[];
    static int s2[];

    public static void main(String[] args) {
        int t = scanner.nextInt();

        String s;
        for (int i = 0; i < t; i++) {
            l1 = scanner.nextInt();
            s1 = new int[l1 + 1];

            s = scanner.next();
            for (int j = 0; j < l1; j++) {
                s1[j + 1] = match(s.charAt(j));
            }

            l2 = scanner.nextInt();
            s2 = new int[l2 + 1];

            s = scanner.next();
            for (int j = 0; j < l2; j++) {
                s2[j + 1] = match(s.charAt(j));
            }

            run();
        }

        scanner.close();
    }

    static int[][] dp;

    static void run() {
        dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 && i == j) {
                    continue;
                }

                dp[i][j] = Integer.MIN_VALUE;

                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + map[s1[i]][s2[j]]);
                }

                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + map[s1[i]][4]);
                }

                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + map[4][s2[j]]);
                }
            }
        }

        System.out.println(dp[l1][l2]);
    }

    static int match(char c) {
        if (c == 'A') {
            return 0;
        }
        if (c == 'C') {
            return 1;
        }
        if (c == 'G') {
            return 2;
        }
        if (c == 'T') {
            return 3;
        }

        return 4;
    }
}
