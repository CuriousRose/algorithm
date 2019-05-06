package hdu.hdu_1067;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Set<Integer> hashSet;
    static LinkedList<Layout> layouts;
    static int[][] input = new int[4][8];

    static Layout goal = new Layout(new int[][]{
            {11, 12, 13, 14, 15, 16, 17, 0},
            {21, 22, 23, 24, 25, 26, 27, 0},
            {31, 32, 33, 34, 35, 36, 37, 0},
            {41, 42, 43, 44, 45, 46, 47, 0}
    }, 0);

    public static void main(String[] args) {
        int t = scanner.nextInt();


        for (int i = 0; i < t; i++) {
            for (int x = 0; x < 4; x++) {
                for (int y = 1; y < 8; y++) {
                    input[x][y] = scanner.nextInt();
                }
            }

            run();
        }
    }

    static void run() {
        Layout init = init();

        if (init.equals(goal)) {
            System.out.println(0);
            return;
        }

        hashSet = new HashSet<>();
        hashSet.add(init.hashCode());

        layouts = new LinkedList<>();
        layouts.add(init);

        int index = 0;

        while (index < layouts.size()) {
            Layout layout = layouts.pollFirst();

            boolean hit = bfs(layout);

            if (hit) {
                return;
            }
        }

        System.out.println(-1);
    }

    static boolean bfs(Layout layout) {

        for (int x = 0; x < 4; x++) {
            for (int y = 1; y < 8; y++) {
                if (layout.map[x][y] == 0) {
                    if (layout.map[x][y - 1] % 10 == 7 || layout.map[x][y - 1] % 10 == 0) {
                        continue;
                    }

                    Layout next = move(layout, x, y);

                    if (next.equals(goal)) {
                        System.out.println(next.step);
                        return true;
                    }

                    if (hashSet.contains(next.hashCode())) {
                        continue;
                    }

                    hashSet.add(next.hashCode());
                    layouts.add(next);
                }
            }
        }

        return false;
    }

    static Layout move(Layout layout, int i, int j) {
        int aim = layout.map[i][j - 1] + 1;

        int map[][] = new int[4][8];
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 8; y++) {
                map[x][y] = layout.map[x][y];
                if (map[x][y] == aim) {
                    map[x][y] = 0;

                }
            }
        }

        map[i][j] = aim;

        return new Layout(map, layout.step + 1);
    }

    static Layout init() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 8; y++) {
                if (input[x][y] % 10 == 1) {
                    input[x][y] = 0;
                }
            }
            input[x][0] = x * 10 + 11;
        }

        return new Layout(input, 0);
    }

    static class Layout {
        int[][] map;
        int step;

        Layout(int[][] map, int step) {
            this.map = map;
            this.step = step;
        }

        @Override
        public int hashCode() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 8; y++) {
                    stringBuffer.append(map[x][y]);
                }
            }

            return stringBuffer.toString().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }
    }
}
