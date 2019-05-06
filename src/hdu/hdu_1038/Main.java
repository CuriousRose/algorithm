package hdu.hdu_1038;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static double d;
    static double r;
    static double t;

    public static void main(String[] args) {

        int i = 0;

        while (scanner.hasNextDouble()) {
            d = scanner.nextDouble();
            r = scanner.nextDouble();
            t = scanner.nextDouble();

            if (r == 0) {
                break;
            }

            i++;

            double s = d * 3.1415927 * r / 5280 / 12;
            double v = s * 60 * 60 / t;
            System.out.println(String.format("Trip #%d: %.2f %.2f", i, s, v));
        }

        scanner.close();
    }
}
