package hdu.hdu_1074;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static Work[] works;
    static int td;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            works = new Work[n];
            td = 0;
            for (int j = 0; j < n; j++) {
                works[j] = new Work(scanner.next(), scanner.nextInt(), scanner.nextInt());
                td += works[j].days;
            }
            run();
        }

        scanner.close();
    }

    static int[] dp;
    static int[] p;
    static int[] c;
    static int[] d;

    static void run() {
        dp = new int[1 << n];
        p = new int[1 << n];
        c = new int[1 << n];
        d = new int[1 << n];

        int tv = 0;

        for (int i = 0; i < n; i++) {
            if (td > works[i].deadline) {
                tv += td - works[i].deadline;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        Set<Integer> rs = new HashSet<>();
        rs.add(0);

        for (int i = 0; i < n; i++) {
            Set<Integer> nrs = new HashSet<>();
            for (int r : rs) {
                for (int j = 0; j < n; j++) {

                    if ((r & (1 << j)) != 0) {
                        continue;
                    }

                    int k = (1 << j) | r;
                    int v = calc(d[r], j);
                    v += dp[r] > 0 ? dp[r] : 0;
                    if (v > dp[k] || (v == dp[k] && better(r, j, k))) {
                        dp[k] = v;
                        d[k] = works[j].days + d[r];
                        p[k] = r;
                        c[k] = j;
                        nrs.add(k);
                    }
                }
            }
            rs = nrs;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            index |= 1 << i;
        }

        System.out.println(tv - dp[index]);

        List<String> list = new ArrayList<>();
        while (index != 0) {
            list.add(works[c[index]].name);
            index = p[index];
        }

        Collections.reverse(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    static boolean better(int r, int j, int k) {
        LinkedList<String> rl = new LinkedList<>();
        int index = r;
        rl.addLast(works[j].name);
        while (index != 0) {
            rl.addFirst(works[c[index]].name);
            index = p[index];
        }

        LinkedList<String> kl = new LinkedList<>();
        index = k;
        while (index != 0) {
            kl.addFirst(works[c[index]].name);
            index = p[index];
        }

        for (int i = 0; i < rl.size(); i++) {
            int c = rl.get(i).compareTo(kl.get(i));
            if (c < 0) {
                return true;
            }
            if (c > 0) {
                return false;
            }
        }
        return false;
    }

    static int calc(int day, int index) {
        int ov = td > works[index].deadline ? td - works[index].deadline : 0;
        int fd = day + works[index].days;
        int cv = fd > works[index].deadline ? fd - works[index].deadline : 0;

        return ov - cv;
    }

    static class Work {
        String name;
        int deadline;
        int days;

        Work(String name, int deadline, int days) {
            this.name = name;
            this.deadline = deadline;
            this.days = days;
        }
    }
}
