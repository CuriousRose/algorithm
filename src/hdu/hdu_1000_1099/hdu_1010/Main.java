package hdu.hdu_1000_1099.hdu_1010;

import java.util.Scanner;

/**
 * 限时迷宫
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    static char[][] routeMap;
    static boolean[][] markMap;

    static int[] px = {-1, 0, +1, 0};
    static int[] py = {0, -1, 0, +1};

    static boolean alive = false;
    static int time = 0;

    public static void main(String[] args) {
        int n, m, t;
        while (true) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            t = scanner.nextInt();

            if (n == 0 && m == 0 && t == 0) {
                break;
            }

            run(n, m, t);
        }

        scanner.close();
    }

    static void run(int n, int m, int t) {
        routeMap = new char[n + 2][m + 2];
        markMap = new boolean[n + 2][m + 2];
        int x = 0;
        int y = 0;
        time = t;
        alive = false;

        for (int i = 1; i <= n; i++) {
            String line = scanner.next();
            for (int j = 1; j <= m; j++) {
                routeMap[i][j] = line.charAt(j - 1);
                if (routeMap[i][j] == 'S') {
                    x = i;
                    y = j;
                    markMap[i][j] = true;
                }
            }
        }

        dfs(x, y, 0);

        if (alive) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static void dfs(int x, int y, int t) {
        if (alive) {
            return;
        }

        if (t >= time) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ox = x + px[i];
            int oy = y + py[i];

            if (markMap[ox][oy]) {
                continue;
            }

            if (routeMap[ox][oy] == '.') {
                markMap[ox][oy] = true;

                dfs(ox, oy, t + 1);

                markMap[ox][oy] = false;
            }

            if (routeMap[ox][oy] == 'D' && t == time - 1) {
                alive = true;
                return;
            }
        }

    }
}
