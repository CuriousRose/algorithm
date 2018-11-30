package hdu.hdu_1002;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int index = 0;

        BigInteger a, b;

        while (index++ < total) {
            if (index > 1) {
                System.out.println();
            }

            a = scanner.nextBigInteger();
            b = scanner.nextBigInteger();
            System.out.println(String.format("Case %d:", index));
            System.out.println(String.format("%d + %d = %d", a, b, a.add(b)));
        }

        scanner.close();
    }
}
