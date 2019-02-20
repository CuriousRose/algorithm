package hdu.hdu_1000_1099.hdu_1059;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int[] ns;
    static int[] vs;
    static boolean[] ms;

    static int c;
    static int t;

    public static void main(String[] args) {
        int index = 1;

        while (true) {
            boolean zero = true;

            ns = new int[7];
            t = 0;

            for (int i = 1; i <= 6; i++) {
                ns[i] = scanner.nextInt();
                t += ns[i] * i;
                if (ns[i] != 0) {
                    zero = false;
                }
            }

            if (zero) {
                break;
            }

            System.out.println(String.format("Collection #%d:", index++));

            run();

            System.out.println();
        }

        scanner.close();
    }

    static void run() {
        if (t % 2 == 1) {
            System.out.println("Can't be divided.");
            return;
        }

        vs = new int[200];
        c = 0;

        for (int i = 1; i <= 6; i++) {
            int k = 1;
            while (ns[i] >= k) {
                c++;
                vs[c] = k * i;
                ns[i] -= k;
                k *= 2;
            }

            if (ns[i] > 0) {
                c++;
                vs[c] = ns[i] * i;
            }
        }

        ms = new boolean[t + 1];
        ms[0] = true;

        for (int i = 1; i <= c; i++) {
            for (int j = t / 2; j >= vs[i]; j--) {
                if (ms[j]) {
                    continue;
                }

                if (ms[j - vs[i]]) {
                    ms[j] = true;
                }
            }
        }


        if (ms[t / 2]) {
            System.out.println("Can be divided.");
        } else {
            System.out.println("Can't be divided.");
        }
    }
}
