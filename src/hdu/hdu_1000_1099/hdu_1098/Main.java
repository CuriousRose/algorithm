package hdu.hdu_1000_1099.hdu_1098;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loop:
        while (scanner.hasNextInt()) {
            int k = scanner.nextInt();

            for (int i = 0; i < 65; i++) {
                int f = 5 + 13 + k * i;
                if (f % 65 == 0) {
                    System.out.println(i);
                    continue loop;
                }
            }
            System.out.println("no");
        }
        scanner.close();
    }
}
