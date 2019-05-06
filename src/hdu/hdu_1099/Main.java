package hdu.hdu_1099;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static F[] fs;

    public static void main(String[] args) {
        fs = new F[23];
        init();

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            fs[n].print();
        }

        scanner.close();
    }

    static void init() {
        for (int i = 1; i <= 22; i++) {
            F f = new F(0, 0, 1);
            for (int j = 1; j <= i; j++) {
                f.add(new F(0, i, j));
            }
            fs[i] = f;
        }
    }

    static class F {
        long a;
        long b;
        long c;

        F(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        F add(F f) {
            this.a += f.a;
            this.b = this.b * f.c + f.b * this.c;
            this.c = this.c * f.c;

            this.a += this.b / this.c;
            this.b %= this.c;

            y();

            return this;
        }

        void y() {
            if (b == 0) {
                return;
            }

            long maxY = maxY(b, c);
            b /= maxY;
            c /= maxY;
        }

        void print() {
            if (b == 0) {
                System.out.println(a);
            } else {
                int al = String.valueOf(a).length();
                int bl = String.valueOf(b).length();
                int cl = String.valueOf(c).length();

                for (int i = 0; i <= al; i++) {
                    System.out.printf(" ");
                }
                System.out.println(b);

                System.out.printf(a + " ");
                for (int i = 0; i < cl; i++) {
                    System.out.printf("-");
                }
                System.out.println();

                for (int i = 0; i <= al; i++) {
                    System.out.printf(" ");
                }
                System.out.println(c);
            }
        }
    }

    static long maxY(long a, long b) {
        if (b % a == 0) {
            return a;
        } else {
            return maxY(b % a, a);
        }
    }
}
