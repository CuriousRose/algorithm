package hdu.hdu_1000_1099.hdu_1032;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static long[] c = new long[1000000 + 1];
    static int l, r;
    static long m;

    public static void main(String[] args) {
        init();

        while (scanner.hasNextInt()) {
            l = scanner.nextInt();
            r = scanner.nextInt();
            m = 0;

            run();
        }

        scanner.close();
    }

    static void init() {
        c[1] = 1;

        for (int i = 2; i <= 1000000; i++) {
            c[i] = calc(i, 0);
        }
    }

    static long calc(long k, int f) {
        if (k <= 1000000 && c[(int) k] != 0) {
            return f + c[(int) k];
        }

        if (k % 2 == 0) {
            return calc(k / 2, f + 1);
        } else {
            return calc(k * 3 + 1, f + 1);
        }
    }

    static void run() {
        for (int i = Math.min(l, r); i <= Math.max(l, r); i++) {
            m = Math.max(c[i], m);
        }
        System.out.println(String.format("%d %d %d", l, r, m));
    }
}
