package hdu.hdu_1000_1099.hdu_1055;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int r;
    static int[] cis;
    static int[] ps;
    static Node[] trees;

    static int sum;
    static int time;
    static boolean[] marks;

    public static void main(String[] args) {
        while (true) {
            n = scanner.nextInt();
            r = scanner.nextInt();

            if (n == 0 && r == 0) {
                break;
            }

            cis = new int[n + 1];
            trees = new Node[n + 1];
            ps = new int[n + 1];


            for (int i = 1; i <= n; i++) {
                cis[i] = scanner.nextInt();
                trees[i] = new Node(cis[i]);
            }

            int v1, v2;
            for (int i = 0; i < n - 1; i++) {
                v1 = scanner.nextInt();
                v2 = scanner.nextInt();

                trees[v1].sons.add(v2);
                trees[v2].parent = v1;
                ps[v2] = v1;
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        int[] road = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            int j = find();

            trees[j].weight = 0;
            road[i] = j;

            int p = trees[j].parent;
            trees[j].merge(p);
        }

        sum = 0;
        marks = new boolean[n + 1];

        time = 1;
        sum += cis[r];
        marks[r] = true;

        for (int i = 0; i < n - 1; i++) {
            for (int j : road) {
                if (marks[j]) {
                    continue;
                }

                int p = ps[j];
                if (marks[p]) {
                    sum += cis[j] * ++time;
                    marks[j] = true;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    static int find() {
        double max = 0;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (i == r) {
                continue;
            }

            if (trees[i].weight > max) {
                max = trees[i].weight;
                index = i;
            }
        }
        return index;
    }

    static class Node {
        int value;
        int parent;
        int count;
        double weight;

        Set<Integer> sons = new HashSet<>();

        Node(int value) {
            this.value = value;
            this.count = 1;
            this.weight = value;
        }

        void merge(int p) {
            for (int k : sons) {
                trees[k].parent = p;
                trees[p].sons.add(k);
            }

            trees[p].value += value;
            trees[p].count += count;
            trees[p].weight = (double) trees[p].value / (double) trees[p].count;
        }
    }
}
