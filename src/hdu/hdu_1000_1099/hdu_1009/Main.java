package hdu.hdu_1000_1099.hdu_1009;

import java.util.*;

/**
 * 代价交换，求和最大收益
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int m, n;
        while (true) {
            m = scanner.nextInt();
            n = scanner.nextInt();

            if (m == -1 && n == -1) {
                break;
            }

            run(m, n);
        }

        scanner.close();
    }

    static void run(int m, int n) {
        double value;
        double cost;

        List<Trade> trades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            value = scanner.nextDouble();
            cost = scanner.nextDouble();

            trades.add(new Trade(value, cost));
        }

        Collections.sort(trades, new Comparator<Trade>() {
            @Override
            public int compare(Trade t1, Trade t2) {
                double vc1 = t1.value / t1.cost;
                double vc2 = t2.value / t2.cost;

                if (vc1 < vc2) {
                    return 1;
                }

                if (vc1 > vc2) {
                    return -1;
                }

                return 0;
            }
        });

        double pounds = m;
        double result = 0.0;

        for (Trade trade : trades) {
            value = trade.value;
            cost = trade.cost;

            if (pounds > cost) {
                pounds -= cost;
                result += value;
                continue;
            }

            result += value * pounds / cost;
            break;
        }

        System.out.println(String.format("%.3f", result));
    }

    static class Trade {
        double value;
        double cost;

        Trade(double value, double cost) {
            this.value = value;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return String.format("%f %f", value, cost);
        }
    }
}
