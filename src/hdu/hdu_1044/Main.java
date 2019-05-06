package hdu.hdu_1044;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int t;

    static int w, h, l, m;
    static int[] mv;
    static char[][] map;

    static Point[] pl;

    static int[][] tm;

    public static void main(String[] args) {

        t = scanner.nextInt();

        for (int index = 1; index <= t; index++) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            l = scanner.nextInt();
            m = scanner.nextInt();

            mv = new int[m + 2];

            for (int i = 0; i < m; i++) {
                mv[i] = scanner.nextInt();
            }

            pl = new Point[m + 2];

            map = new char[h][w];

            String s;
            for (int i = 0; i < h; i++) {
                s = scanner.next();

                for (int j = 0; j < w; j++) {
                    char c = s.charAt(j);

                    map[i][j] = c;

                    if (c >= 'A' && c <= 'J') {
                        int k = c - 'A';
                        pl[k] = new Point(i, j);
                    }

                    if (c == '@') {
                        pl[m] = new Point(i, j);
                    }

                    if (c == '<') {
                        pl[m + 1] = new Point(i, j);
                    }
                }
            }

            tm = new int[m + 2][m + 2];

            run(index);
        }

        scanner.close();
    }

    static int[][] bm;
    static Queue<Point> bq;


    static void run(int index) {
        if (index != 1) {
            System.out.println();
        }
        System.out.println(String.format("Case %d:", index));
        for (int i = 0; i < m + 1; i++) {
            Point p = pl[i];

            bq = new LinkedList<>();
            bq.add(p);

            bm = new int[h][w];

            while (!bq.isEmpty()) {
                p = bq.poll();

                int t = bm[p.x][p.y];

                bfs(p, t);
            }

            for (int j = 0; j < m + 2; j++) {
                if (i == j) {
                    continue;
                }

                p = pl[j];

                tm[i][j] = bm[p.x][p.y];

            }
        }

        dm = new boolean[m + 2];
        max = -1;

        dm[m] = true;
        dfs(m, 0, 0);

        if (max == -1) {
            System.out.println("Impossible");
        } else {
            System.out.println(String.format("The best score is %d.", max));
        }
    }

    static int[] px = {-1, 1, 0, 0};
    static int[] py = {0, 0, -1, 1};

    static void bfs(Point p, int t) {

        if (t >= l) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cx = p.x + px[i];
            int cy = p.y + py[i];

            if (cx < 0 || cy < 0 || cx >= h || cy >= w) {
                continue;
            }

            if (map[cx][cy] == '*') {
                continue;
            }

            if (bm[cx][cy] != 0) {
                continue;
            }

            bm[cx][cy] = t + 1;
            bq.add(new Point(cx, cy));
        }
    }

    static boolean[] dm;
    static int max;

    static void dfs(int i, int v, int t) {

        for (int j = 0; j < m; j++) {
            if (dm[j]) {
                continue;
            }

            if (tm[i][j] == 0) {
                continue;
            }

            if (t + tm[i][j] > l) {
                continue;
            }

            dm[j] = true;

            dfs(j, v + mv[j], t + tm[i][j]);

            dm[j] = false;
        }

        if (tm[i][m + 1] == 0) {
            return;
        }

        if (t + tm[i][m + 1] <= l) {
            max = Math.max(max, v);
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


