package hdu.hdu_1000_1099.hdu_1069;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int n;
    static TreeSet<Block> blocks;

    public static void main(String[] args) {
        int index = 1;

        while (true) {
            n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            blocks = new TreeSet<>();

            int x, y, z;

            for (int i = 0; i < n; i++) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                z = scanner.nextInt();

                blocks.add(new Block(x, y, z));
                blocks.add(new Block(x, z, y));
                blocks.add(new Block(y, x, z));
                blocks.add(new Block(y, z, x));
                blocks.add(new Block(z, x, y));
                blocks.add(new Block(z, y, x));
            }

            run(index++);
        }

        scanner.close();
    }

    static int[] dp;
    static Block[] list;

    static void run(int index) {
        dp = new int[blocks.size()];
        list = blocks.toArray(new Block[blocks.size()]);

        dp[0] = list[0].height;
        int max = dp[0];

        for (int i = 1; i < list.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list[i].length < list[j].length && list[i].width < list[j].width) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i] += list[i].height;
            max = Math.max(max, dp[i]);
        }

        System.out.println(String.format("Case %d: maximum height = %d", index, max));
    }

    static class Block implements Comparable<Block> {
        int length;
        int width;
        int height;

        Block(int length, int width, int height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

        @Override
        public int compareTo(Block o) {
            int dl = o.length - this.length;
            int dw = o.width - this.width;
            int dh = o.height - this.height;
            return dl != 0 ? dl : dw != 0 ? dw : dh;
        }
    }
}
