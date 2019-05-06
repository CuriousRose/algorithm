package hdu.hdu_1025;

import java.util.Scanner;

/**
 * 求最长上升子串
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static int[] r;

    static int[] m;

    static int s;

    public static void main(String[] args) {

        int index = 0;
        int x, y;

        while (scanner.hasNextInt()) {
            index++;

            n = scanner.nextInt();
            r = new int[n + 1];

            m = new int[n + 1];

            s = 0;

            for (int i = 0; i < n; i++) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                r[x] = y;
            }

            run();
            System.out.println(String.format("Case %d:", index));
            if (s <= 1) {
                System.out.println(String.format("My king, at most %d road can be built.", s));
            } else {
                System.out.println(String.format("My king, at most %d roads can be built.", s));
            }

            System.out.println();
        }

        scanner.close();
    }

    static void run() {

        for (int i = 1; i <= n; i++) {

            if (r[i] > m[s]) {
                ++s;
                m[s] = r[i];
            } else {
                int f = find(r[i], 1, s);
                m[f] = r[i];
            }
        }
    }

    static int find(int i, int l, int r) {
        if (i < m[l]) {
            return l;
        }

        int mid = (l + r) / 2;

        if (m[mid] < i) {
            return find(i, mid + 1, r);
        } else {
            return find(i, l, mid);
        }
    }
}
