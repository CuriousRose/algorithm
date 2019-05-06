package hdu.hdu_1056;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static double c;
    static List<Double> list = new ArrayList<>();

    public static void main(String[] args) {
        init();

        while (true) {
            c = scanner.nextDouble();

            if (c == 0.00) {
                break;
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) >= c) {
                    System.out.println(String.format("%d card(s)", i));
                    break;
                }
            }
        }

        scanner.close();
    }

    static void init() {
        double index = 1;
        double total = 0;
        list.add(total);
        while (total <= 5.20) {
            index++;
            total += 1 / index;
            list.add(total);
        }
    }
}
