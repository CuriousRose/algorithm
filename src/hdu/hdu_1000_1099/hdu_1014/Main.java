package hdu.hdu_1000_1099.hdu_1014;

import java.util.Scanner;

/**
 * 给定表达式,判断随机数是否均匀
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int step, mod;
        while (scanner.hasNextInt()) {
            step = scanner.nextInt();
            mod = scanner.nextInt();

            run(step, mod);
        }

        scanner.close();
    }

    static void run(int step, int mod) {
        int index = 0;
        int count = 0;
        boolean mark[] = new boolean[mod + 1];
        while (!mark[index]) {
            mark[index] = true;

            index += step;
            index %= mod;

            count++;
        }

        String result = "Bad Choice";

        if (count == mod) {
            result = "Good Choice";
        }

        System.out.println(String.format("%10d%10d    %s", step, mod, result));
        System.out.println();
    }
}
