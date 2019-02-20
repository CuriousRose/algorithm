package hdu.hdu_1000_1099.hdu_1058;


import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int[] l = {2, 3, 5, 7};
    static int[] list = new int[5843];

    public static void main(String[] args) {
        init();

        int n;

        while (true) {
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            String mark = "th";
            if (n % 10 == 1 && n % 100 != 11) {
                mark = "st";
            }

            if (n % 10 == 2 && n % 100 != 12) {
                mark = "nd";
            }

            if (n % 10 == 3 && n % 100 != 13) {
                mark = "rd";
            }

            System.out.println(String.format("The %d%s humble number is %d.", n, mark, list[n]));
        }
    }

    static void init() {
        int[] p = {1, 1, 1, 1};
        list[1] = 1;

        for (int i = 2; i <= 5842; i++) {
            int[] r = new int[4];

            for (int j = 0; j < 4; j++) {
                while (list[p[j]] * l[j] <= list[i - 1]) {
                    p[j]++;
                }

                r[j] = list[p[j]] * l[j];
            }

            int min = r[0];
            int iin = 0;

            for (int j = 1; j < 4; j++) {
                if (r[j] < min) {
                    min = r[j];
                    iin = j;
                }
            }

            list[i] = min;
            p[iin]++;
        }
    }
}
