package hdu.hdu_1003;

import java.util.Scanner;

/**
 * 最大子序列之和
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int total = scanner.nextInt();
        int index = 0;

        while (index++ < total) {
            if (index != 1) {
                System.out.println();
            }

            System.out.println(String.format("Case %d:", index));
            demo(index);
        }

        scanner.close();
    }

    public static void demo(int item) {
        int length = scanner.nextInt();
        int[] list = new int[length + 1];
        for (int index = 1; index <= length; index++) {
            list[index] = scanner.nextInt();
        }

        int head = 1;
        int current = list[1];

        int start = 1;
        int end = 1;
        int max = list[1];

        for (int index = 2; index <= length; index++) {
            if (current >= 0) {
                current += list[index];
            } else {
                current = list[index];
                head = index;
            }

            if (current > max) {
                max = current;
                start = head;
                end = index;
            }
        }

        System.out.println(String.format("%d %d %d", max, start, end));
        return;
    }
}
