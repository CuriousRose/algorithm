package hdu.hdu_1049;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n, u, d;

    public static void main(String[] args) {
        while (true) {
            n = scanner.nextInt();
            u = scanner.nextInt();
            d = scanner.nextInt();

            if (n == 0 && u == 0 && d == 0) {
                break;
            }

            int t = (n - u) / (u - d) * 2;

            if ((n - u) % (u - d) != 0) {
                t += 2;
            }

            t++;

            System.out.println(t);
        }

        scanner.close();
    }
}
