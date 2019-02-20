package hdu.hdu_1000_1099.hdu_1043;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, Integer> parent;
    static Map<Integer, Character> action;
    static Queue<Integer> queue;

    static int aim = 123456789;

    public static void main(String[] args) {
        init();

        while (scanner.hasNext()) {

            int k = 0;
            String s;

            for (int i = 100000000; i >= 1; i /= 10) {
                s = scanner.next();
                if (s.equals("x")) {
                    k += i * 9;
                } else {
                    k += i * Integer.parseInt(s);
                }
            }

            if (k == aim) {
                System.out.println("lr");
                continue;
            }

            run(k);
        }

        scanner.close();
    }

    static void init() {
        parent = new TreeMap<>();
        action = new TreeMap<>();
        queue = new LinkedList<>();

        parent.put(aim, 0);
        queue.add(aim);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            bfs(i);
        }
    }

    static void run(int i) {

        if (!parent.containsKey(i)) {
            System.out.println("unsolvable");
            return;
        }

        while (parent.get(i) != 0) {
            System.out.print(action.get(i));
            i = parent.get(i);
        }
        System.out.println();
    }

    static void bfs(int i) {
        String s = String.valueOf(i);
        int k = find(s);

        if (k > 2) {
            char[] c = s.toCharArray();
            c[k] = c[k - 3];
            c[k - 3] = '9';
            check(c, i, 'd');
        }

        if (k < 6) {
            char[] c = s.toCharArray();
            c[k] = c[k + 3];
            c[k + 3] = '9';
            check(c, i, 'u');
        }

        if (k % 3 > 0) {
            char[] c = s.toCharArray();
            c[k] = c[k - 1];
            c[k - 1] = '9';
            check(c, i, 'r');
        }

        if (k % 3 < 2) {
            char[] c = s.toCharArray();
            c[k] = c[k + 1];
            c[k + 1] = '9';
            check(c, i, 'l');
        }
    }

    static int find(String s) {
        for (int i = 0; i < 9; i++) {
            if (s.charAt(i) == '9') {
                return i;
            }
        }
        return 0;
    }

    static void check(char[] c, int p, char a) {
        String s = String.valueOf(c);
        int i = Integer.parseInt(s);
        if (parent.containsKey(i)) {
            return;
        }

        parent.put(i, p);
        action.put(i, a);
        queue.add(i);
    }
}
