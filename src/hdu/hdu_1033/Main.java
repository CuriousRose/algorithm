package hdu.hdu_1033;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int x, y;
    static String s;

    static int[] px = {10, 0, -10, 0};
    static int[] py = {0, -10, 0, 10};

    static int p = 0;

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            s = scanner.next();

            x = 300;
            y = 420;
            p = 0;

            run();
        }

        scanner.close();
    }

    static void run() {
        System.out.println(String.format("%d %d moveto", x, y));

        for (int i = 0; i < s.length(); i++) {
            x += px[p];
            y += py[p];

            System.out.println(String.format("%d %d lineto", x, y));

            char c = s.charAt(i);


            if (c == 'A') {
                p = (p + 1 + 4) % 4;
            }

            if (c == 'V') {
                p = (p - 1 + 4) % 4;
            }
        }

        x += px[p];
        y += py[p];

        System.out.println(String.format("%d %d lineto", x, y));
        System.out.println("stroke");
        System.out.println("showpage");
    }
}
