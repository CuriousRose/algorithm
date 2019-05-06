package hdu.hdu_1093;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
        scanner.close();
    }
}
