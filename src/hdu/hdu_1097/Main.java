package hdu.hdu_1097;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            a %= 10;
            list.add(a);
            int c = a * a % 10;
            while (c != list.get(0)) {
                list.add(c);
                c = a * c % 10;
            }
            int d = b % list.size();
            if (d == 0) {
                d = list.size() - 1;
            } else {
                d--;
            }
            System.out.println(list.get(d));
        }
        scanner.close();
    }
}
