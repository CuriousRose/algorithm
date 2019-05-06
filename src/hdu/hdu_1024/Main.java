package hdu.hdu_1024;

import java.util.*;

/**
 * 给定序列,求分成多个子段,求最大和
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int n, m;
    static int[] s;
    static long[][] dp;
    static int f;
    static long max;

    public static void main(String[] args) {

        while (scanner.hasNextInt()) {
            m = scanner.nextInt();
            n = scanner.nextInt();

            s = new int[n + 1];
            dp = new long[2][n + 1];
            f = 1;

            for (int i = 1; i <= n; i++) {
                s[i] = scanner.nextInt();
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        for (int i = 1; i <= m; i++) {
            max = Long.MIN_VALUE;
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    dp[f][j] = dp[1 - f][j - 1] + s[j];
                } else {
                    dp[f][j] = Math.max(dp[f][j - 1], dp[1 - f][j - 1]) + s[j];
                }
                dp[f][j - 1] = max;
                max = Math.max(dp[f][j], max);
            }
            f = 1 - f;
        }
        System.out.println(max);
    }
}