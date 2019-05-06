package hdu.hdu_1070;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static TreeSet<Milk> milks;

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            milks = new TreeSet<>();

            for (int j = 0; j < n; j++) {
                Milk milk = new Milk(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                if (milk.volume < 200) {
                    continue;
                }
                milks.add(milk);
            }

            System.out.println(milks.first().name);
        }

        scanner.close();
    }

    static class Milk implements Comparable<Milk> {
        String name;
        double cost;
        double volume;

        double pd;

        Milk(String name, double cost, double volume) {
            this.name = name;
            this.cost = cost;
            this.volume = volume;

            if (volume < 200) {
                pd = 0;
            } else {
                pd = cost / Math.min(5, (int) volume / 200);
            }
        }

        @Override
        public int compareTo(Milk o) {
            if (this.pd == o.pd) {
                if (this.volume == o.volume) {
                    return 0;
                }
                if (this.volume < o.volume) {
                    return 1;
                }
                if (this.volume > o.volume) {
                    return -1;
                }
            }
            if (this.pd > o.pd) {
                return 1;
            }
            if (this.pd < o.pd) {
                return -1;
            }

            return 0;
        }
    }
}
