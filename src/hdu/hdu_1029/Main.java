package hdu.hdu_1029;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static List<Integer> list;

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();

            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }

            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    return i1 - i2;
                }
            });

            int aim = list.get(0);
            int c = 1;

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) == aim) {
                    c++;
                    continue;
                }

                if (c >= (n + 1) / 2) {
                    break;
                }

                aim = list.get(i);
                c = 1;
            }

            System.out.println(aim);
        }

        scanner.close();
    }
}
