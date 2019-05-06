package hdu.hdu_1085;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n1, n2, n5;
    static boolean mark[];

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n1 = scanner.nextInt();
            n2 = scanner.nextInt();
            n5 = scanner.nextInt();

            if (n1 == 0 && n2 == 0 && n5 == 0) {
                break;
            }

            int l = n1 + 2 * n2 + 5 * n5 + 1;

            mark = new boolean[l + 1];
            for (int i = 0; i <= n1; i++) {
                mark[i] = true;
            }

            for (int i = n1; i >= 0; i--) {
                for (int j = n2; j > 0; j--) {
                    mark[i + j * 2] = true;
                }
            }

            for (int i = n1 + n2 * 2; i >= 0; i--) {
                if (!mark[i]) {
                    continue;
                }

                for (int j = n5; j > 0; j--) {
                    mark[i + j * 5] = true;
                }
            }

            for (int i = 0; i <= l; i++) {
                if (!mark[i]) {
                    System.out.println(i);
                    break;
                }
            }
        }

        scanner.close();
    }
}
