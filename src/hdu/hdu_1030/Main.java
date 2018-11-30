package hdu.hdu_1030;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int m, n;
    static List<Floor> floors = new ArrayList<>();

    public static void main(String[] args) {
        init();

        while (scanner.hasNextInt()) {
            m = scanner.nextInt();
            n = scanner.nextInt();

            int a = Math.min(m, n);
            int b = Math.max(m, n);

            int dis = run(a, b);
            System.out.println(dis);
        }

        scanner.close();
    }

    static int run(int a, int b) {
        Floor fa = find(a);
        Floor fb = find(b);

        if (fa.floor == fb.floor) {
            return b - a;
        }

        int pf = fb.floor - fa.floor;
        int px = Math.abs((fa.mid - a) - (fb.mid - b));
        int py = pf - 1;

        int dis = (pf - 1) * 2 + 1;
        if (fa.floor % 2 != a % 2) {
            py++;
            dis++;
        }

        if (fb.floor % 2 == b % 2) {
            py++;
            dis++;
        }

        dis = dis + Math.max(px - py, 0);

        return dis;
    }

    static Floor find(int x) {
        for (Floor floor : floors) {
            if (floor.left <= x && floor.right >= x) {
                return floor;
            }
        }

        return null;
    }

    static void init() {
        int floor = 0;
        int left = 0;
        int right = 0;
        int count = -1;
        int total = 0;

        while (total <= 1000000000) {
            count += 2;
            floor++;
            left = total + 1;
            right = total + count;
            total += count;

            floors.add(new Floor(floor, count, left, right));
        }
    }

    static class Floor {
        int floor;
        int count;
        int left;
        int right;
        int mid;

        Floor(int floor, int count, int left, int right) {
            this.floor = floor;
            this.count = count;
            this.left = left;
            this.right = right;
            this.mid = (left + right) / 2;
        }
    }
}
