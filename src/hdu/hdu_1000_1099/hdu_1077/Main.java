package hdu.hdu_1000_1099.hdu_1077;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static double[] px;
    static double[] py;

    static double r = 1.0001;

    static double cx;
    static double cy;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            px = new double[n];
            py = new double[n];
            for (int j = 0; j < n; j++) {
                px[j] = scanner.nextDouble();
                py[j] = scanner.nextDouble();
            }
            run();
        }

        scanner.close();
    }

    static void run() {
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!calc(i, j)) {
                    continue;
                }

                int count = 0;
                for (int k = 0; k < n; k++) {

                    double x = px[k];
                    double y = py[k];

                    if (dis(x, y, cx, cy) <= r * r) {
                        count++;
                    }
                }

                ans = Math.max(ans, count);
            }
        }

        System.out.println(ans);
    }

    static boolean calc(int i, int j) {
        double x1 = px[i];
        double y1 = py[i];
        double x2 = px[j];
        double y2 = py[j];

        if (dis(x1, y1, x2, y2) > 4) {
            return false;
        }

        double dx = x1 - x2;
        double dy = y1 - y2;

        double xm = (x1 + x2) / 2;
        double ym = (y1 + y2) / 2;

        double dis = Math.sqrt(1 - dis(x1, y1, xm, ym));

        double k = Math.atan(-dx / dy);
        cx = xm + Math.cos(k) * dis;
        cy = ym + Math.sin(k) * dis;

        return true;
    }

    static double dis(double x1, double y1, double x2, double y2) {
        return ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
