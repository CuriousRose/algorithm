package hdu.hdu_1005;

import java.util.Scanner;

/**
 * 递归表达式，求第N次计算，mod值
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a, b, total;

        while (true) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            total = scanner.nextInt();

            if (a == 0 && b == 0 && total == 0) {
                break;
            }

            run(a, b, total);
        }

        scanner.close();
    }

    static void run(int a, int b, int total) {
        int f[] = {1, 1};
        int history[] = new int[10000];
        history[1] = 1;
        history[2] = 1;
        int m = 0;

        for (int i = 3; i <= total; i++) {
            f[m] = (a * f[1 - m] + b * f[m]) % 7;
            history[i] = f[m];

            for (int j = 2; j <= i - 1; j++) {
                if (history[j - 1] == f[1 - m] && history[j] == f[m]) {
                    int length = i - j;
                    int mod = (total - (j - 2)) % length;
                    if (mod == 0) {
                        mod = length;
                    }

                    System.out.println(history[(j - 2) + mod]);
                    return;
                }
            }

            m = 1 - m;
        }

        System.out.println(f[1 - m]);
    }
}
