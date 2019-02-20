package hdu.hdu_1000_1099.hdu_1076;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int year = scanner.nextInt();
            int index = scanner.nextInt();

            while (true) {
                if (isLeap(year)) {
                    if (--index == 0) {
                        break;
                    }
                }

                year++;
            }

            System.out.println(year);
        }

        scanner.close();
    }

    static boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        }

        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }

        return false;
    }
}
