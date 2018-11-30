package hdu.hdu_1036;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static double d;
    static int m;

    public static void main(String[] args) {
        n = scanner.nextInt();
        d = scanner.nextDouble();

        while (scanner.hasNextInt()) {
            m = scanner.nextInt();

            double t = 0;
            String time;
            boolean failed = false;

            for (int i = 0; i < n; i++) {
                time = scanner.next();

                if (time.equals("-:--:--")) {
                    failed = true;
                    continue;
                }

                t += parserTime(time);
            }

            if (failed) {
                System.out.println(String.format("%3d: -", m));
                continue;
            }

            int avg = (int) Math.round(t / d);
            System.out.println(String.format("%3d: %d:%02d min/km", m, avg / 60, avg % 60));
        }


        scanner.close();
    }

    static int parserTime(String time) {
        String[] splits = time.split(":");
        return Integer.parseInt(splits[0]) * 60 * 60 + Integer.parseInt(splits[1]) * 60 + Integer.parseInt(splits[2]);
    }
}
