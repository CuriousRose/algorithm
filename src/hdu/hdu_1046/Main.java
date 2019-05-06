package hdu.hdu_1046;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int t, m, n;

    public static void main(String[] args) {
        t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            m = scanner.nextInt();
            n = scanner.nextInt();

            double s = m * n;
            if (m % 2 == 1 && n % 2 == 1) {
                s += 0.41;
            }

            System.out.println(String.format("Scenario #%d:", i));
            System.out.println(String.format("%.2f", s));
            System.out.println();
        }

        scanner.close();
    }
}
