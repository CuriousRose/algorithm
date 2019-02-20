package hdu.hdu_1000_1099.hdu_1053;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String s;

    static LinkedList<Tree> chars;
    static LinkedList<Tree> trees;

    public static void main(String[] args) {
        while (true) {
            s = scanner.next();
            if (s.equals("END")) {
                break;
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);

        chars = new LinkedList<>();

        char k = cs[0];
        int t = 0;
        for (char c : cs) {
            if (c == k) {
                t++;
            } else {
                chars.add(new Tree(k, t));
                k = c;
                t = 1;
            }
        }

        chars.add(new Tree(k, t));

        chars.sort(new Comparator<Tree>() {
            @Override
            public int compare(Tree t1, Tree t2) {
                return t1.t - t2.t;
            }
        });

        trees = new LinkedList<>();

        while (chars.size() + trees.size() > 1) {
            Tree t1 = getMin();
            Tree t2 = getMin();

            trees.addLast(new Tree(t1.t + t2.t, t1, t2));
        }

        Tree h = trees.pollFirst();
        int score = 0;

        if (h == null) {
            h = chars.pollFirst();
            score = h.t;
        } else {
            score = load(h, 0);
        }

        int ascii = s.length() * 8;
        double ratio = (double) ascii / (double) score;
        System.out.println(String.format("%d %d %.1f", ascii, score, ratio));

    }

    static int load(Tree t, int d) {
        if (t.c != null) {
            return d * t.t;
        } else {
            return load(t.l, d + 1) + load(t.r, d + 1);
        }
    }

    static Tree getMin() {
        if (chars.isEmpty()) {
            return trees.pollFirst();
        }

        if (trees.isEmpty()) {
            return chars.pollFirst();
        }

        if (chars.getFirst().t < trees.getFirst().t) {
            return chars.pollFirst();
        } else {
            return trees.pollFirst();
        }
    }

    static class Tree {
        Character c;
        int t;
        Tree l;
        Tree r;

        Tree(char c, int t) {
            this.c = c;
            this.t = t;
        }

        Tree(int t, Tree l, Tree r) {
            this.t = t;
            this.l = l;
            this.r = r;
        }
    }
}
