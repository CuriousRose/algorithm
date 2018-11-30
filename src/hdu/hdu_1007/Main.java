package hdu.hdu_1007;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            run(n);
        }

        scanner.close();
    }

    static void run(int n) {
        List<Point> points = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();

        double x, y;

        for (int i = 0; i < n; i++) {
            x = scanner.nextDouble();
            y = scanner.nextDouble();
            points.add(new Point(x, y));
        }

        double minDis = calcDis(points.get(0), points.get(1));

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x > p2.x) {
                    return 1;
                }

                if (p1.x < p2.x) {
                    return -1;
                }

                if (p1.y > p2.y) {
                    return 1;
                }

                if (p1.y < p2.y) {
                    return -1;
                }

                return 0;
            }
        });

        int index = 0;
        double axis = points.get(0).x;

        for (int i = 1; i < points.size(); i++) {
            Point point = points.get(i);

            if (point.x == axis) {
                continue;
            }

            intervals.add(new Interval(axis, index, i));
            index = i;
            axis = point.x;
        }

        intervals.add(new Interval(axis, index, points.size()));

        for (int i = 0; i < intervals.size(); i++) {
            Interval leftInterval = intervals.get(i);
            double leftAxis = leftInterval.axis;

            List<Point> leftPoints = points.subList(leftInterval.left, leftInterval.right);

            if (leftPoints.size() > 1) {
                for (int k = 0; k < leftPoints.size() - 1; k++) {
                    double dis = leftPoints.get(k + 1).y - leftPoints.get(k).y;
                    minDis = Math.min(dis, minDis);
                }
            }

            for (int j = i + 1; j < intervals.size(); j++) {
                Interval rightInterval = intervals.get(j);
                double rightAxis = rightInterval.axis;

                if (rightAxis - leftAxis > minDis) {
                    break;
                }

                List<Point> rightPoints = points.subList(rightInterval.left, rightInterval.right);

                for (Point leftPoint : leftPoints) {
                    double leftY = leftPoint.y;
                    Point findPoint = findNearPoint(leftY, rightPoints);
                    double currDis = calcDis(leftPoint, findPoint);
                    minDis = Math.min(currDis, minDis);
                }
            }
        }
        System.out.println(String.format("%.2f", minDis / 2));
    }

    static Point findNearPoint(double y, List<Point> points) {
        Point leftPoint = points.get(0);
        if (points.size() == 1) {
            return leftPoint;
        }

        if (leftPoint.y > y) {
            return leftPoint;
        }

        Point rightPoint = points.get(points.size() - 1);
        if (rightPoint.y < y) {
            return rightPoint;
        }

        if (points.size() == 2) {
            double leftDis = y - leftPoint.y;
            double rightDis = rightPoint.y - y;
            return leftDis < rightDis ? leftPoint : rightPoint;
        }

        int mid = points.size() / 2;
        Point midPoint = points.get(mid);

        if (midPoint.y > y) {
            return findNearPoint(y, points.subList(0, mid + 1));
        }

        if (midPoint.y < y) {
            return findNearPoint(y, points.subList(mid, points.size()));
        }

        return midPoint;
    }

    static double calcDis(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%f,%f", x, y);
        }
    }

    static class Interval {
        double axis;
        int left;
        int right;

        Interval(double axis, int left, int right) {
            this.axis = axis;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.format("%f,%d,%d", axis, left, right);
        }
    }
}
