package hdu.hdu_1047;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int n;
    static int[] h;
    static int l;

    public static void main(String[] args) {
        n = scanner.nextInt();

        String s;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                System.out.println();
            }

            h = new int[1000];
            l = 0;

            while (true) {
                s = scanner.next();
                if (s.equals("0")) {
                    break;
                }

                int k = 0;
                for (int j = s.length() - 1; j >= 0; j--, k++) {
                    int v = s.charAt(j) - '0';

                    h[k] += v;
                }

                l = Math.max(l, s.length() - 1);

                for (int j = 0; j <= l; j++) {
                    if (h[j] >= 10) {
                        h[j + 1] += h[j] / 10;
                        h[j] %= 10;
                    }
                }

                while (h[l + 1] != 0) {
                    l++;
                }
            }

            for (int j = l; j >= 0; j--) {
                System.out.print(h[j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
