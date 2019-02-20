package hdu.hdu_1000_1099.hdu_1095;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt() + scanner.nextInt());
            System.out.println();
        }
        scanner.close();
    }
}
