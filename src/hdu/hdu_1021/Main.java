package hdu.hdu_1021;

import java.util.Scanner;

/**
 * 判断Fibonacci数列,能否mod3
 */

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            run();
        }

        scanner.close();
    }

    static void run() {
        int[] f = new int[2];
        int index = 0;

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                f[index] = 1;
            } else if (i == 1) {
                f[index] = 2;
            } else {
                f[index] = (f[index] + f[1 - index]) % 3;
            }

            index = 1 - index;
        }

        System.out.println(f[1 - index] % 3 == 0 ? "yes" : "no");
    }
}
