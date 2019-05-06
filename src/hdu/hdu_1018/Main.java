package hdu.hdu_1018;

import java.util.Scanner;

/**
 * 计算阶乘结果位数
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int total;
    static int n;

    public static void main(String[] args) {
        total = scanner.nextInt();
        while (total-- > 0) {
            n = scanner.nextInt();
            int digit = (int) ((0.5 * Math.log(2 * Math.PI * n) + n * Math.log(n) - n) / Math.log(10));
            System.out.println(digit + 1);
        }

        scanner.close();
    }
}
