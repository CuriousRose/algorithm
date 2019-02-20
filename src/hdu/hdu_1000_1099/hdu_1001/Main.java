package hdu.hdu_1000_1099.hdu_1001;

import java.util.Scanner;

/**
 * 自然序列求和
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            System.out.println((a % 2 == 0 ? a / 2 * (a + 1) : (a + 1) / 2 * a));
            System.out.println();
        }
        scanner.close();
    }
}
