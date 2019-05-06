package hdu.hdu_1057;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int days;
    static int[][][] map;
    static int[] d;

    public static void main(String[] args) {
        int t;

        t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            if (i > 0) {
                System.out.println();
            }

            days = scanner.nextInt();
            d = new int[16];
            map = new int[20][20][2];

            for (int j = 0; j < 16; j++) {
                d[j] = scanner.nextInt();
            }


            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    map[j][k][0] = scanner.nextInt();
                }
            }

            run();
        }

        scanner.close();
    }

    static int[] px = {-1, 1, 0, 0};
    static int[] py = {0, 0, -1, 1};

    static void run() {
        int m = 0;

        for (int i = 0; i < days; i++) {
            for (int x = 0; x < 20; x++) {
                for (int y = 0; y < 20; y++) {
                    int k = map[x][y][m];

                    for (int l = 0; l < 4; l++) {
                        int cx = x + px[l];
                        int cy = y + py[l];

                        if (cx >= 0 && cx < 20 && cy >= 0 && cy < 20) {
                            k += map[cx][cy][m];
                        }
                    }

                    map[x][y][1 - m] = map[x][y][m] + d[k];
                    if (map[x][y][1 - m] > 3) {
                        map[x][y][1 - m] = 3;
                    }
                    if (map[x][y][1 - m] < 0) {
                        map[x][y][1 - m] = 0;
                    }
                }
            }

            m = 1 - m;
        }

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                if (map[x][y][m] == 0) {
                    System.out.print(".");
                }
                if (map[x][y][m] == 1) {
                    System.out.print("!");
                }
                if (map[x][y][m] == 2) {
                    System.out.print("X");
                }
                if (map[x][y][m] == 3) {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
