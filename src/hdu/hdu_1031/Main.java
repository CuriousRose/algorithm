package hdu.hdu_1031;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n, m, k;
    static double[] v;
    static int[] p;

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();

            v = new double[m + 1];
            p = new int[m + 1];

            for (int i = 1; i <= m; i++) {
                p[i] = i;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= m; j++) {
                    v[j] += scanner.nextDouble();
                }
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        sort_v(1, m);
        sort_p(m - k + 1, m);
        for (int i = m - k + 1; i <= m; i++) {
            if (i != m - k + 1) {
                System.out.print(" ");
            }
            System.out.print(p[i]);
        }
        System.out.println();

    }

    static void sort_v(int x, int y) {
        if (x >= y) {
            return;
        }

        int cx = x;
        int cy = y;
        double z = v[cx];
        int i = p[cx];

        while (cx < cy) {
            while (v[cx] <= v[cy] && cx < cy) {
                if (v[cx] == v[cy] && p[cx] < p[cy]) {
                    break;
                }
                cy--;
            }

            v[cx] = v[cy];
            v[cy] = z;

            p[cx] = p[cy];
            p[cy] = i;

            while (v[cx] <= v[cy] && cx < cy) {
                if (v[cx] == v[cy] && p[cx] < p[cy]) {
                    break;
                }
                cx++;
            }

            v[cy] = v[cx];
            v[cx] = z;

            p[cy] = p[cx];
            p[cx] = i;
        }

        sort_v(x, cx - 1);
        sort_v(cy + 1, y);
    }

    static void sort_p(int x, int y) {
        if (x >= y) {
            return;
        }

        int cx = x;
        int cy = y;
        int i = p[cx];
        double z = v[cx];

        while (cx < cy) {
            while (p[cx] > p[cy] && cx < cy) {
                cy--;
            }

            p[cx] = p[cy];
            p[cy] = i;

            v[cx] = v[cy];
            v[cy] = z;

            while (p[cx] > p[cy] && cx < cy) {
                cx++;
            }

            p[cy] = p[cx];
            p[cx] = i;

            v[cy] = v[cx];
            v[cx] = z;
        }

        sort_p(x, cx - 1);
        sort_p(cy + 1, y);
    }
}
