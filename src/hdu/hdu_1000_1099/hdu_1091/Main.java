package hdu.hdu_1000_1099.hdu_1091;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == 0 && b == 0) {
                break;
            }

            System.out.println(a + b);
        }

        scanner.close();
    }
}
