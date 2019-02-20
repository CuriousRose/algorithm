package hdu.hdu_1000_1099.hdu_1068;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            n = scanner.nextInt();

            map = new HashMap<>();
            String s;

            for (int i = 0; i < n; i++) {
                s = scanner.next();
                int index = Integer.parseInt(s.replace(":", ""));
                List<Integer> list = new ArrayList<>();

                s = scanner.next();
                int count = Integer.parseInt(s.replace("(", "").replace(")", ""));
                for (int j = 0; j < count; j++) {
                    list.add(scanner.nextInt());
                }

                map.put(index, list);
            }

            run();
        }

        scanner.close();
    }

    static Integer[] match;
    static boolean[] pass;

    static void run() {
        match = new Integer[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            pass = new boolean[n];

            boolean isMatch = find(i);
            if (isMatch) {
                count++;
            }
        }

        System.out.println(n - count / 2);
    }

    static boolean find(int i) {
        List<Integer> list = map.get(i);

        for (int index = 0; index < list.size(); index++) {
            int j = list.get(index);

            if (pass[j]) {
                continue;
            }

            pass[j] = true;

            if (match[j] == null || find(match[j])) {
                match[j] = i;
                return true;
            }
        }
        return false;
    }
}
