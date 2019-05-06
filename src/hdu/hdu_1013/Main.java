package hdu.hdu_1013;

import java.util.Scanner;

/**
 * 循环计算给定数字之和(直到剩一位)
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("0")) {
                break;
            }

            System.out.println(calc(line));
        }

        scanner.close();
    }

    static int calc(String line) {
        int total = 0;
        for (char c : line.toCharArray()) {
            total += c - 48;
        }

        if (total < 10) {
            return total;
        }

        return calc(String.valueOf(total));
    }
}
