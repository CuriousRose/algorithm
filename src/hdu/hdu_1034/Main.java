package hdu.hdu_1034;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int[][] l;

    static int t;

    public static void main(String[] args) {
        while (true) {
            n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            l = new int[n][2];

            for (int i = 0; i < n; i++) {
                l[i][0] = scanner.nextInt();
            }

            t = 0;

            run();
        }

        scanner.close();
    }

    static void run() {
        while (true) {
            t++;

            for (int i = 0; i < n - 1; i++) {
                l[i][0] /= 2;
                l[i + 1][1] = l[i][0];
            }

            l[n - 1][0] /= 2;
            l[0][1] = l[n - 1][0];

            for (int i = 0; i < n; i++) {
                l[i][0] += l[i][1];
                if (l[i][0] % 2 == 1) {
                    l[i][0]++;
                }
            }

            boolean s = true;

            for (int i = 1; i < n; i++) {
                if (l[i][0] != l[0][0]) {
                    s = false;
                    break;
                }
            }

            if (s) {
                System.out.println(String.format("%d %d", t, l[0][0]));
                break;
            }
        }
    }
}
