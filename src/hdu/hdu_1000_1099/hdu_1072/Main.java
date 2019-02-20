package hdu.hdu_1000_1099.hdu_1072;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int[] px = {0, 0, -1, 1};
    static int[] py = {-1, 1, 0, 0};

    static int n, m;
    static int map[][];
    static Point h;
    static Point a;

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            map = new int[n][m];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    map[x][y] = scanner.nextInt();
                    if (map[x][y] == 2) {
                        h = new Point(x, y, 1, 6);
                    }
                    if (map[x][y] == 3) {
                        a = new Point(x, y, 0, 0);
                    }
                }
            }

            run();
        }

        scanner.close();
    }


    static int time[][];
    static int foot[][];
    static LinkedList<Point> list;

    static void run() {
        time = new int[n][m];
        foot = new int[n][m];
        list = new LinkedList<>();

        time[h.x][h.y] = h.t;
        foot[h.x][h.y] = h.f;
        list.add(h);

        while (!list.isEmpty()) {
            Point point = list.poll();
            bfs(point);
        }


        if (foot[a.x][a.y] > 0) {
            System.out.println(foot[a.x][a.y] - 1);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(Point point) {
        if (point.t <= 1) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cx = point.x + px[i];
            int cy = point.y + py[i];

            if (cx < 0 || cx >= n || cy < 0 || cy >= m) {
                continue;
            }

            if (map[cx][cy] == 0) {
                continue;
            }

            int cf = point.f + 1;
            int ct = point.t - 1;
            if (map[cx][cy] == 4) {
                ct = 6;
            }

            if (cf < foot[cx][cy] || ct > time[cx][cy]) {
                if (foot[cx][cy] == 0 || cf < foot[cx][cy]) {
                    foot[cx][cy] = cf;
                }
                time[cx][cy] = Math.max(time[cx][cy], ct);

                list.add(new Point(cx, cy, cf, ct));
            }
        }
    }

    static class Point {
        int x;
        int y;
        int f;
        int t;

        Point(int x, int y, int f, int t) {
            this.x = x;
            this.y = y;
            this.f = f;
            this.t = t;
        }
    }
}
