package hdu.hdu_1022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定入栈顺序,判断能否以给定顺序出栈
 */

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static String s1, s2;
    static char[] s;
    static int index;
    static List<String> steps;
    static boolean success = false;

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();

            s1 = scanner.next();
            s2 = scanner.next();

            s = new char[n + 1];
            index = 0;
            success = false;
            steps = new ArrayList<>();

            run();

            System.out.println("FINISH");
        }

        scanner.close();
    }

    static void run() {
        int i1 = 0;
        int i2 = 0;
        while (i2 < n) {
            if (s[index] == s2.charAt(i2)) {
                steps.add("out");

                index--;
                i2++;
                continue;
            }

            if (i1 < n) {
                steps.add("in");
                s[++index] = s1.charAt(i1++);
                continue;
            }

            System.out.println("No.");
            return;
        }

        System.out.println("Yes.");

        for (String step : steps) {
            System.out.println(step);
        }
    }
}
