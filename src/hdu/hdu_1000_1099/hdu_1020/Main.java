package hdu.hdu_1000_1099.hdu_1020;

import java.util.Scanner;

/**
 * 根据规则,替换表达式
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int N;
    static String str;

    public static void main(String[] args) {
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            str = scanner.next();

            run();
        }

        scanner.close();
    }

    static void run() {
        StringBuffer result = new StringBuffer();

        char c = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            } else {
                if (count > 1) {
                    result.append(count).append(c);
                } else {
                    result.append(c);
                }

                count = 1;
                c = str.charAt(i);
            }
        }

        if (count > 1) {
            result.append(count).append(c);
        } else {
            result.append(c);
        }

        System.out.println(result.toString());
    }
}
