package hdu.hdu_1017;

import java.util.Scanner;

/**
 * 计算符合给定表达式数量
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n, m;
    static int index;

    public static void main(String[] args) {
        int N = scanner.nextInt();
        while (N-- > 0) {
            scanner.nextLine();
            index = 0;

            while (true) {
                n = scanner.nextInt();
                m = scanner.nextInt();

                if (n == 0 && m == 0) {
                    break;
                }

                index++;
                run();
            }

            if (N > 0) {
                System.out.println();
            }
        }

        scanner.close();
    }

    static void run() {
        int count = 0;

        for (int a = 1; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                if ((a * a + b * b + m) % (a * b) == 0) {
                    count++;
                }
            }
        }

        System.out.println(String.format("Case %d: %d", index, count));
    }
}
