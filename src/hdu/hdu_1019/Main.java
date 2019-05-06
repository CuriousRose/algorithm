package hdu.hdu_1019;

import java.util.Scanner;

/**
 * 最小公倍数
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n, m, k;
    static int aim;

    public static void main(String[] args) {
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            m = scanner.nextInt();

            for (int j = 0; j < m; j++) {
                k = scanner.nextInt();

                if (j == 0) {
                    aim = k;
                } else {
                    aim = aim < k ? lcm(aim, k) : lcm(k, aim);
                }
            }

            System.out.println(aim);
        }

        scanner.close();
    }

    static int lcm(int x, int y) {
        int gcd = gcd(x, y);
        return x / gcd * y;
    }

    static int gcd(int x, int y) {
        if (y % x == 0) {
            return x;
        } else {
            return gcd(y % x, x);
        }
    }
}
