package hdu.hdu_1000_1099.hdu_1045;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int n;
    static char[][] map;

    public static void main(String[] args) {

        while (scanner.hasNextInt()) {

            n = scanner.nextInt();
            if (n == 0) {
                return;
            }

            map = new char[n][n];

            String s;
            for (int i = 0; i < n; i++) {
                s = scanner.next();
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        cm = new boolean[n * n];
        mm = new int[n][n];
        max = 0;

        dfs(0, 0);
        System.out.println(max);
    }

    static boolean[] cm;
    static int[][] mm;
    static int max;

    static void dfs(int d, int c) {
        if (d >= n * n) {
            return;
        }

        int x = d / n;
        int y = d % n;

        if (map[x][y] == '.' && mm[x][y] == 0) {

            cmm(x, y, 1);

            max = Math.max(max, c + 1);
            dfs(d + 1, c + 1);

            cmm(x, y, -1);
        }

        dfs(d + 1, c);
    }

    static int[] px = {-1, 1, 0, 0};
    static int[] py = {0, 0, -1, 1};

    static void cmm(int x, int y, int v) {
        mm[x][y] += v;

        for (int i = 0; i < 4; i++) {
            int cx = x + px[i];
            int cy = y + py[i];

            while (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                if (map[cx][cy] == 'X') {
                    break;
                }

                mm[cx][cy] += v;

                cx += px[i];
                cy += py[i];
            }
        }
    }
}
