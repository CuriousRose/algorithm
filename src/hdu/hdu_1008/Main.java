package hdu.hdu_1008;

import java.util.Scanner;

/**
 * 计算乘坐电梯时间
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        while (true) {
            n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            run(n);
        }

        scanner.close();
    }

    static void run(int n) {
        int floor = 0;
        int aim;
        int time = 0;

        for (int i = 0; i < n; i++) {
            aim = scanner.nextInt();
            time += aim > floor ? (aim - floor) * 6 : (floor - aim) * 4;
            time += 5;

            floor = aim;
        }

        System.out.println(time);
    }
}
