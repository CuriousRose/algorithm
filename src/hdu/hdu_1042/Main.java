package hdu.hdu_1042;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static BigInteger[] l;

    public static void main(String[] args) {
        init();

        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            System.out.println(l[n]);
        }

        scanner.close();
    }

    static void init() {
        l = new BigInteger[10000 + 1];

        l[0] = new BigInteger("1");

        for (int i = 1; i <= 10000; i++) {
            l[i] = l[i - 1].multiply(new BigInteger(String.valueOf(i)));
        }
    }
}
