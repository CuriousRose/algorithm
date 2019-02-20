package hdu.hdu_1000_1099.hdu_1086;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static List<Line> lines;
    static List<Point> points;

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            lines = new ArrayList<>();

            double x1, y1, x2, y2;
            for (int i = 0; i < n; i++) {
                x1 = scanner.nextDouble();
                y1 = scanner.nextDouble();
                x2 = scanner.nextDouble();
                y2 = scanner.nextDouble();

                lines.add(link(new Point(x1, y1), new Point(x2, y2)));
            }

            points = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    Line l1 = lines.get(i);
                    Line l2 = lines.get(j);

                    Point point = across(l1, l2);
                    if (point != null) {
                        points.add(point);
                    }
                }
            }

            System.out.println(points.size());
        }

        scanner.close();
    }

    static Line link(Point p1, Point p2) {
        if (p1.x == p2.x) {
            return new Line(true, 0, 0, p1.x, p2.x);
        }

        double a = (p2.y - p1.y) / (p2.x - p1.x);
        double b = p1.y - a * p1.x;
        return new Line(false, a, b, Math.min(p1.x, p2.x), Math.max(p1.x, p2.x));
    }

    static Point across(Line l1, Line l2) {
        if (l1.col == l2.col && l1.a == l2.a) {
            return null;
        }

        if (l1.col) {
            double x = l1.xl;
            double y = x * l2.a + l2.b;
            if (x < l2.xl || x > l2.xr) {
                return null;
            }
            return new Point(x, y);
        }

        if (l2.col) {
            double x = l2.xl;
            double y = x * l1.a + l1.b;
            if (x < l1.xl || x > l1.xr) {
                return null;
            }
            return new Point(x, y);
        }

        double x = (l2.b - l1.b) / (l1.a - l2.a);
        double y = x * l1.a + l1.b;
        if (x < l1.xl || x > l1.xr) {
            return null;
        }
        if (x < l2.xl || x > l2.xr) {
            return null;
        }
        return new Point(x, y);
    }

    static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = ((int) (x * 100)) / 100.0;
            this.y = ((int) (y * 100)) / 100.0;
        }
    }

    static class Line {
        boolean col;
        double a;
        double b;

        double xl;
        double xr;

        Line(boolean col, double a, double b, double xl, double xr) {
            this.col = col;
            this.a = a;
            this.b = b;

            this.xl = xl;
            this.xr = xr;
        }
    }
}
