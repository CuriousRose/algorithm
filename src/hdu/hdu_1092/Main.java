package hdu.hdu_1092;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += scanner.nextInt();
            }

            System.out.println(sum);
        }
        scanner.close();
    }
}
