package hdu.hdu_1040;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n, m;
    static int[] s;

    public static void main(String[] args) {
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            m = scanner.nextInt();
            s = new int[m];

            for (int j = 0; j < m; j++) {
                s[j] = scanner.nextInt();
            }

            run();
        }
    }

    static void run() {
        Arrays.sort(s);
        for (int i = 0; i < m; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(s[i]);
        }
        System.out.println();
    }
}
