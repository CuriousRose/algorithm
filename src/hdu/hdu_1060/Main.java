package hdu.hdu_1060;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            double d = Math.log10(n) * n;
            d -= Math.floor(d);

            System.out.println((int) Math.pow(10, d));
        }

        scanner.close();
    }
}
