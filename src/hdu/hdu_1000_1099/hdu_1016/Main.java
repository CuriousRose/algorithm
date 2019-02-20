package hdu.hdu_1000_1099.hdu_1016;

import java.util.Scanner;

/**
 * 搜索符合条件(相邻数字之和为素数),全部结果
 */

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n;

    static int[] df;
    static boolean use[];

    static boolean[] prime = new boolean[40];

    public static void main(String[] args) {

        int index = 0;

        for (int i = 2; i < 40; i++) {
            boolean mark = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    mark = false;
                    break;
                }
            }

            prime[i] = mark;
        }

        while (scanner.hasNextInt()) {
            n = scanner.nextInt();

            df = new int[n + 1];
            use = new boolean[n + 1];

            df[1] = 1;
            use[1] = true;

            System.out.println(String.format("Case %d:", ++index));

            dfs(2);

            System.out.println("");
        }
        scanner.close();
    }

    static void dfs(int deep) {

        if (deep > n) {
            if (prime[df[deep - 1] + df[1]]) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 1; i < deep; i++) {
                    if (i == 1) {
                        stringBuffer.append(df[i]);
                    } else {
                        stringBuffer.append(" " + df[i]);
                    }
                }
                System.out.println(stringBuffer.toString());
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (use[i]) {
                continue;
            }

            if (prime[df[deep - 1] + i]) {
                df[deep] = i;
                use[i] = true;

                dfs(deep + 1);

                use[i] = false;
            }
        }
    }
}
