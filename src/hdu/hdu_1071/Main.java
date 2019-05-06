package hdu.hdu_1071;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static double x1, x2, x3, y1, y2, y3;
    static double a, b, c, k, d, r1, r2;

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            x1 = scanner.nextDouble();
            y1 = scanner.nextDouble();
            x2 = scanner.nextDouble();
            y2 = scanner.nextDouble();
            x3 = scanner.nextDouble();
            y3 = scanner.nextDouble();

            a = (y2 - y1) / (x2 - x1) / (x2 - x1);
            b = -2 * a * x1;
            c = a * x1 * x1 + y1;

            k = (y3 - y2) / (x3 - x2);
            d = y2 - k * x2;

            r1 = a / 3 * x3 * x3 * x3 + (b - k) / 2 * x3 * x3 + (c - d) * x3;
            r2 = a / 3 * x2 * x2 * x2 + (b - k) / 2 * x2 * x2 + (c - d) * x2;

            System.out.println(String.format("%.2f", Math.abs(r1 - r2)));
        }

        scanner.close();
    }
}
