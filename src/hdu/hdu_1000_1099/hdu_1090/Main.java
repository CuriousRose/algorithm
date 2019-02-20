package hdu.hdu_1000_1099.hdu_1090;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(scanner.nextInt() + scanner.nextInt());
        }
        scanner.close();
    }
}
