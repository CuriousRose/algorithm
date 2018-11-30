package hdu.hdu_1026;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n, m;

    static int[][] map;
    static Queue<Point> queue;

    static int[][] time;

    static Point[][] fp;

    static int[] px = {-1, +1, 0, 0};
    static int[] py = {0, 0, -1, +1};

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                int j = -1;
                for (char c : scanner.next().toCharArray()) {
                    j++;

                    if (c == '.') {
                        map[i][j] = 0;
                        continue;
                    }
                    if (c == 'X') {
                        map[i][j] = -1;
                        continue;
                    }
                    map[i][j] = c - '0';
                }
            }

            queue = new LinkedBlockingQueue<>();
            time = new int[n][m];
            fp = new Point[n][m];

            run();
        }

        scanner.close();
    }

    static void run() {
        queue.add(new Point(0, 0, map[0][0]));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            dfs(point);
        }

        int t = time[n - 1][m - 1];

        if (t == 0) {
            System.out.println("God please help our poor hero.");
            System.out.println("FINISH");
            return;
        }

        System.out.println(String.format("It takes %d seconds to reach the target position, let me show you the way.", t));

        List<Point> points = new ArrayList<>();

        Point point = new Point(n - 1, m - 1, t);

        while (point != null) {
            points.add(point);
            point = fp[point.x][point.y];
        }

        t = 0;

        for (int i = points.size() - 1; i >= 0; i--) {
            point = points.get(i);
            int x = point.x;
            int y = point.y;

            if (fp[x][y] != null) {
                t++;
                System.out.println(String.format("%ds:(%d,%d)->(%d,%d)", t, fp[x][y].x, fp[x][y].y, x, y));
            }

            for (int j = 0; j < map[x][y]; j++) {
                t++;
                System.out.println(String.format("%ds:FIGHT AT (%d,%d)", t, x, y));
            }
        }

        System.out.println("FINISH");
    }

    static void dfs(Point point) {
        int x = point.x;
        int y = point.y;
        int t = point.t;

        if (t > time[x][y]) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cx = x + px[i];
            int cy = y + py[i];

            if (cx == 0 && cy == 0) {
                continue;
            }

            if (cx < 0 || cx >= n || cy < 0 || cy >= m) {
                continue;
            }

            if (map[cx][cy] == -1) {
                continue;
            }

            int ct = t + map[cx][cy] + 1;

            if (time[cx][cy] == 0 || ct < time[cx][cy]) {
                queue.add(new Point(cx, cy, ct));
                fp[cx][cy] = point;
                time[cx][cy] = ct;
            }
        }

    }

    static class Point {
        int x;
        int y;
        int t;

        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
