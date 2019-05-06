package hdu.hdu_1066;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    static int a[] = {1, 1, 2, 6, 4, 2, 2, 4, 2, 8};
    static int h[] = {6, 4};

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            String s = scanner.next();

            System.out.println(calc(s));
        }
    }

    static int calc(String s) {

        int l = s.length();
        int m = s.charAt(l - 1) - '0';
        int t = a[m];

        if (l == 1) {
            return t;
        }

        StringBuffer sb = new StringBuffer();

        int k = 0;
        int r;
        char c;

        for (int i = 0; i < l; i++) {
            r = (k * 10 + s.charAt(i) - '0') / 5;

            if (sb.length() > 0 || r != 0) {
                c = (char) (r + '0');
                sb.append(c);
            }

            k = (k * 10 + s.charAt(i) - '0') % 5;
        }

        return h[(s.charAt(l - 2) - '0') % 2] * t * calc(sb.toString()) % 10;
    }
}
