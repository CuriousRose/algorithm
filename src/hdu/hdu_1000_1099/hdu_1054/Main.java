package hdu.hdu_1000_1099.hdu_1054;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    static int n;
    static Tree[] trees;
    static int soldier;

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            soldier = 0;

            trees = new Tree[n];

            String s;

            for (int i = 0; i < n; i++) {
                s = scanner.next();

                String splits[] = s.split(":");
                int k = Integer.parseInt(splits[0]);

                if (trees[k] == null) {
                    trees[k] = new Tree(k);
                }

                int m = Integer.parseInt(splits[1].replace("(", "").replace(")", ""));

                int v;
                for (int j = 0; j < m; j++) {
                    v = scanner.nextInt();

                    if (trees[v] == null) {
                        trees[v] = new Tree(v);
                    }

                    trees[v].parent = trees[k];
                    trees[k].sons.add(trees[v]);
                }
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        Tree h = trees[0];
        while (h.parent != null) {
            h = h.parent;
        }

        mark(h);

        System.out.println(soldier);
    }

    static void mark(Tree t) {
        for (Tree son : t.sons) {
            mark(son);
        }

        if (t.mark) {
            return;
        }

        if (t.parent != null) {
            if (t.parent.mark) {
                t.link();
                return;
            } else {
                t.parent.mark();
                t.link();
                soldier++;
                return;
            }
        } else {
            if (!t.link) {
                t.mark();
                soldier++;
                return;
            }
        }
    }

    static class Tree {
        int c;
        boolean mark;
        boolean link;
        Tree parent;
        List<Tree> sons = new ArrayList<>();

        Tree(int c) {
            this.c = c;
        }

        void mark() {
            mark = true;

            if (parent != null) {
                parent.link = true;
            }
        }

        void link() {
            link = true;
        }
    }
}
