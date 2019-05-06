package hdu.hdu_1078;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static int k;
    static int[][] map;

    public static void main(String[] args) {
        while (true) {
            n = scanner.nextInt();
            k = scanner.nextInt();

            if (n == -1 && k == -1) {
                break;
            }

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            run();
        }

        scanner.close();
    }

    static Queue<Point> queue;
    static int[][] score;
    static int max;

    static void run() {
        score = new int[n][n];
        queue = new LinkedList<>();

        queue.add(new Point(0, 0));
        score[0][0] = map[0][0];
        max = score[0][0];

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            bfs(point);
        }

        System.out.println(max);
    }

    static int[] px = {0, 0, -1, 1};
    static int[] py = {-1, 1, 0, 0};

    static void bfs(Point point) {
        int x = point.x;
        int y = point.y;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 4; j++) {
                int cx = x + i * px[j];
                int cy = y + i * py[j];

                if (cx < 0 || cx >= n || cy < 0 || cy >= n) {
                    continue;
                }

                if (map[cx][cy] <= map[x][y]) {
                    continue;
                }

                int cs = score[x][y] + map[cx][cy];
                if (cs > score[cx][cy]) {
                    score[cx][cy] = cs;
                    max = Math.max(max, cs);
                    queue.add(new Point(cx, cy));
                }
            }
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
