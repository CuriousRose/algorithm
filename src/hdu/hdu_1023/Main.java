package hdu.hdu_1023;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BigInteger[][] dt = new BigInteger[101][101];
    static int n;

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    dt[i][j] = new BigInteger(String.valueOf(1));
                    continue;
                }

                dt[i][j] = dt[i][j - 1].add(dt[i - 1][j]);
            }

            dt[i][i] = dt[i][i - 1];
        }

        while (scanner.hasNextInt()) {
            n = scanner.nextInt();

            System.out.println(dt[n][n]);
        }
        scanner.close();
    }
}
