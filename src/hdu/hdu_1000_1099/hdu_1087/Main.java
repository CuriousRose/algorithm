package hdu.hdu_1000_1099.hdu_1087;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static int list[];

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            list = new int[n];

            for (int i = 0; i < n; i++) {
                list[i] = scanner.nextInt();
            }

            run();
        }
    }

    static int dp[];
    static int max;

    static void run() {
        max = 0;
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = list[i];
            for (int j = n - 1; j >= 0; j--) {
                if (list[j] < list[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + list[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
