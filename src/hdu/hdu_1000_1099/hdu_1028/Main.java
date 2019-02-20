package hdu.hdu_1000_1099.hdu_1028;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static long[][] dp = new long[120 + 1][120 + 1];
    static int n;

    public static void main(String[] args) {

        for (int i = 1; i <= 120; i++) {
            for (int j = 0; j <= 120; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                for (int k = 0; k <= j; k += i) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        while (scanner.hasNextInt()) {
            n = scanner.nextInt();

            System.out.println(dp[n][n]);
        }

        scanner.close();
    }
}
