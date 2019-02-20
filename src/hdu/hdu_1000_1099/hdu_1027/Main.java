package hdu.hdu_1000_1099.hdu_1027;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 求全排列中,指定索引的序列
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n, m;
    static List<Integer> list;

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }

            list = calc(list, m);
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(list.get(i));
            }
            System.out.println();
        }

        scanner.close();
    }

    static List<Integer> calc(List<Integer> l, int c) {
        if (c == 1) {
            return l;
        }

        int i = 1;
        int j = 1;

        while (j * i < c) {
            j *= i;
            i++;
        }

        i--;

        int k = (c - 1) / j + 1;

        List<Integer> r = new LinkedList<>();

        if (l.size() > i) {
            r.addAll(l.subList(0, l.size() - i - 1));
            r.add(l.get(l.size() - i - 1 + k - 1));
        } else {
            r.add(l.get(k - 1));
        }

        List<Integer> s = new LinkedList<>();
        s.addAll(l.subList(l.size() - i - 1, l.size()));
        s.remove(k - 1);

        r.addAll(calc(s, c - (k - 1) * j));

        return r;
    }
}
