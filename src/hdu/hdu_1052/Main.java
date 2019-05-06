package hdu.hdu_1052;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int n;
    static int[] x;
    static int[] y;

    public static void main(String[] args) {

        while (true) {
            n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            x = new int[n];
            y = new int[n];

            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                y[i] = scanner.nextInt();
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        Arrays.sort(x);
        Arrays.sort(y);

        boolean m[] = new boolean[n];

        int c = 0;

        int xl = 0, xr = n - 1;
        int yl = 0, yr = n - 1;

        for (int i = 0; i < n; i++) {
            if (x[xl] > y[yl]) {
                xl++;
                yl++;
                c += 200;
                continue;
            }

            if (x[xl] < y[yl]) {
                xl++;
                yr--;
                c -= 200;
                continue;
            }

            if (x[xr] > y[yr]) {
                xr--;
                yr--;
                c += 200;
                continue;
            }

            if (x[xr] < y[yr]) {
                xl++;
                yr--;
                c -= 200;
                continue;
            }

            if (x[xl] < y[yr]) {
                c -= 200;
            }

            xl++;
            yr--;
            continue;
        }

        System.out.println(c);

    }
}
