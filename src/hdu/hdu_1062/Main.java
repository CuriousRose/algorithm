package hdu.hdu_1062;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static String str;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            str = scanner.nextLine();

            run();
        }

        scanner.close();
    }

    static void run() {
        StringBuffer result = new StringBuffer();

        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                result.append(new StringBuffer(str.substring(j, i)).reverse());
                result.append(' ');
                j = i + 1;
            }
        }
        if (j < str.length()) {
            result.append(new StringBuffer(str.substring(j, str.length())).reverse());
        }

        System.out.println(result);
    }
}
