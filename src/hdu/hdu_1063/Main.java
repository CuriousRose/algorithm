package hdu.hdu_1063;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static String s;
    static int n;

    public static void main(String[] args) {
        while (scanner.hasNextDouble()) {
            s = scanner.next();
            n = scanner.nextInt();

            run();
        }

        scanner.close();
    }

    static void run() {
        int p = 0;

        StringBuffer sb = new StringBuffer();

        boolean m = false;
        boolean k = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                m = true;
                continue;
            }

            if (m) {
                p++;
            }

            if (s.charAt(i) != '0') {
                k = true;
            }

            if (s.charAt(i) != '.' && k) {
                sb.append(s.charAt(i));
            }
        }

        BigInteger sd = new BigInteger(sb.toString());
        BigInteger rd = new BigInteger("1");

        int tp = 0;

        for (int i = 0; i < n; i++) {
            rd = rd.multiply(sd);
            tp += p;
        }

        String str = rd.toString();

        StringBuffer result = new StringBuffer();
        if (tp > str.length()) {
            result.append(".0");
            tp--;

            while (tp > str.length()) {
                result.append("0");
                tp--;
            }

            result.append(str);
        } else {
            int j = 0;

            while (tp < str.length() - j) {
                result.append(str.charAt(j));
                j++;
            }

            result.append(".");
            result.append(str.substring(j));
        }

        int j = result.length();
        while (result.charAt(j - 1) == '0') {
            j--;
        }

        if (result.charAt(j - 1) == '.') {
            j--;
        }

        System.out.println(result.substring(0, j));
    }
}
