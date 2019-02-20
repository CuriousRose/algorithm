package hdu.hdu_1000_1099.hdu_1051;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int t;
    static int n;
    static Stick[] sticks;


    public static void main(String[] args) {
        t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();

            sticks = new Stick[n];

            for (int j = 0; j < n; j++) {
                sticks[j] = new Stick();

                sticks[j].l = scanner.nextInt();
                sticks[j].w = scanner.nextInt();
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        Arrays.sort(sticks, new Comparator<Stick>() {
            @Override
            public int compare(Stick s1, Stick s2) {
                return s1.l - s2.l;
            }
        });

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(sticks[i].w);
        }

        int c = 0;
        while (!list.isEmpty()) {
            Iterator<Integer> iterable = list.iterator();

            int m = iterable.next();
            iterable.remove();
            c++;

            while (iterable.hasNext()) {
                int k = iterable.next();
                if (k >= m) {
                    m = k;
                    iterable.remove();
                }
            }
        }

        System.out.println(c);
    }

    static class Stick {
        int l;
        int w;
    }
}