package hdu.hdu_1083;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int p, n;

    static int[][] map;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            p = scanner.nextInt();
            n = scanner.nextInt();

            map = new int[p + 1][n + 1];

            for (int i = 1; i <= p; i++) {
                map[i][0] = scanner.nextInt();

                for (int j = 1; j <= map[i][0]; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            run();
        }
    }

    static int match[];
    static boolean mark[];

    static void run() {
        match = new int[n + 1];

        int count = 0;

        for (int i = 1; i <= p; i++) {
            mark = new boolean[n + 1];

            if (find(i)) {
                count++;
            }
        }

        if (count == p) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean find(int i) {
        for (int j = 1; j <= map[i][0]; j++) {
            int k = map[i][j];

            if (mark[k]) {
                continue;
            }

            mark[k] = true;
            if (match[k] == 0 || find(match[k])) {
                match[k] = i;
                return true;
            }
        }

        return false;
    }
}
