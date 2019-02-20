package hdu.hdu_1000_1099.hdu_1041;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static BigInteger[] zz;
    static BigInteger[] o;

    public static void main(String[] args) {
        init();

        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            System.out.println(zz[n]);
        }

        scanner.close();
    }

    static void init() {
        BigInteger two = new BigInteger("2");
        BigInteger l = new BigInteger("1");

        zz = new BigInteger[1000 + 1];
        o = new BigInteger[1000 + 1];
        zz[0] = new BigInteger("0");
        o[0] = new BigInteger("1");

        for (int i = 1; i <= 1000; i++) {
            o[i] = l;
            l = l.multiply(two);

            zz[i] = new BigInteger("0");
            if (i > 1) {
                zz[i] = zz[i - 2];
                zz[i] = zz[i].add(o[i - 2]);
            }
        }
    }
}
