package hdu.hdu_1006;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 计算时钟，指针间角度，所占时间比
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int HOUR = 12;
    static int MINUTE = 60;
    static int SECOND = 60;

    static double HOUR_SPEED = 1.0 * 6 / 60 / 12;
    static double MINUTE_SPEED = 1.0 * 6 / 60;
    static double SECOND_SPEED = 1.0 * 6;

    public static void main(String[] args) {
        double d;

        while (true) {
            d = scanner.nextDouble();

            if (d == -1) {
                break;
            }

            Hand h = new Hand(HOUR_SPEED);
            Hand m = new Hand(MINUTE_SPEED);
            Hand s = new Hand(SECOND_SPEED);

            double happy = 0.0;

            for (int i = 0; i < HOUR; i++) {
                for (int j = 0; j < MINUTE; j++) {
                    double start_second = i * SECOND * MINUTE + j * SECOND;

                    h.time(start_second);
                    m.time(start_second);
                    s.time(start_second);

                    HandInterval hm = calc(h, m, d);
                    HandInterval hs = calc(h, s, d);
                    HandInterval ms = calc(m, s, d);

                    happy += intersection(hm, hs, ms);
                }
            }

            double percent = happy * 100 / HOUR / MINUTE / SECOND;
            System.out.println(String.format("%.3f", percent));
        }

        scanner.close();
    }

    static class Hand {
        double speed;
        double degree;

        Hand(double speed) {
            this.speed = speed;
        }

        void time(double second) {
            degree = second * speed % 360;
        }
    }

    static class Interval {
        double left;
        double right;

        Interval(double left, double right) {
            this.left = left;
            this.right = right;
        }

        boolean isZero() {
            return this.left > this.right;
        }
    }

    static class HandInterval extends Interval {
        double cycle;

        HandInterval(double left, double right, double cycle) {
            super(left, right);
            this.cycle = cycle;
        }

        Interval nextInterval() {
            return new Interval(this.left + cycle, this.right + cycle);
        }

        Interval beforeInterval() {
            return new Interval(this.left - cycle, this.right - cycle);
        }
    }

    static HandInterval calc(Hand a, Hand b, double d) {
        double cycle = 360 / (b.speed - a.speed);

        double t1 = (d - (b.degree - a.degree)) / (b.speed - a.speed);
        double t2 = (360 - d - (b.degree - a.degree)) / (b.speed - a.speed);

        return new HandInterval(t1, t2, cycle);
    }

    static double intersection(HandInterval... handIntervals) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 60));

        for (HandInterval handInterval : handIntervals) {
            List<Interval> newIntervals = new ArrayList<>();
            for (Interval interval : intervals) {
                if (interval.isZero()) {
                    continue;
                }

                newIntervals.add(intersection(interval, handInterval));

                if (handInterval.right > interval.right) {
                    Interval beforeInterval = handInterval.beforeInterval();
                    newIntervals.add(intersection(interval, beforeInterval));
                }

                if (handInterval.left < interval.left) {
                    Interval nextInterval = handInterval.nextInterval();
                    newIntervals.add(intersection(interval, nextInterval));
                }
            }
            intervals = newIntervals;
        }

        double happy = 0.0;
        for (Interval interval : intervals) {
            if (interval.isZero()) {
                continue;
            }
            happy += interval.right - interval.left;
        }

        return happy;
    }

    static Interval intersection(Interval a, Interval b) {
        return new Interval(Math.max(a.left, b.left), Math.min(a.right, b.right));
    }
}
