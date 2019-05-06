package hdu.hdu_1065;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t;

        t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            double r = Math.sqrt(x * x + y * y);
            double s = 3.1415926 * r * r / 2;
            double n = s / 50;
            n += 1;

            long year = (long) (n + 1e-6);

            System.out.printf("Property %d: This property will begin eroding in year %d.%n", i, year);

        }
        System.out.printf("END OF OUTPUT.%n");

        scanner.close();
    }
}
