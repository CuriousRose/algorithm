package hdu.hdu_1035;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n, m;
    static int x, y;

    static int[][] map;
    static int[][] step;

    static int index;

    static int[] px = {-1, 1, 0, 0};
    static int[] py = {0, 0, 1, -1};

    public static void main(String[] args) {
        while (true) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            y = scanner.nextInt();

            if (n == 0 && m == 0 && y == 0) {
                break;
            }

            x = 0;
            y--;
            index = 1;

            map = new int[n][m];
            step = new int[n][m];

            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                for (int j = 0; j < m; j++) {
                    char c = s.charAt(j);
                    if (c == 'N') {
                        map[i][j] = 0;
                    }
                    if (c == 'S') {
                        map[i][j] = 1;
                    }
                    if (c == 'E') {
                        map[i][j] = 2;
                    }
                    if (c == 'W') {
                        map[i][j] = 3;
                    }
                }
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        step[x][y] = index;

        while (true) {
            int s = map[x][y];

            x += px[s];
            y += py[s];

            if (x < 0 || x >= n || y < 0 || y >= m) {
                System.out.println(String.format("%d step(s) to exit", index));
                return;
            }

            if (step[x][y] != 0) {
                System.out.println(String.format("%d step(s) before a loop of %d step(s)", step[x][y] - 1, index - step[x][y] + 1));
                return;
            }

            index++;
            step[x][y] = index;
        }
    }
}
