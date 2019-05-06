package hdu.hdu_1015;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 根据规则,搜索符合的结果
 */

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int[][] square = new int[26 + 1][5 + 1];
    static int length;

    static int[] klein;
    static boolean[] use;

    static int target;

    static int[] df = new int[5 + 1];
    static boolean find = false;

    public static void main(String[] args) {
        for (int i = 1; i <= 26; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j == 1) {
                    square[i][j] = i;
                } else {
                    square[i][j] = square[i][j - 1] * -i;
                }
            }
        }

        String str;
        while (true) {
            target = scanner.nextInt();
            str = scanner.next();

            if (target == 0 && str.equals("END")) {
                break;
            }

            length = str.length();

            klein = new int[length];
            use = new boolean[length];

            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                klein[i] = c - 'A' + 1;
            }

            Arrays.sort(klein);

            find = false;
            dfs(1);

            if (!find) {
                System.out.println("no solution");
            }
        }

        scanner.close();
    }

    static void dfs(int deep) {

        if (find) {
            return;
        }

        if (deep > 5) {
            int calc = 0;
            for (int i = 1; i < deep; i++) {
                calc += square[df[i]][i];
            }

            if (calc == target) {
                find = true;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 1; i < deep; i++) {
                    stringBuffer.append((char) (df[i] + 'A' - 1));
                }
                System.out.println(stringBuffer.toString());
            }

            return;
        }

        for (int i = length - 1; i >= 0; i--) {
            if (use[i]) {
                continue;
            }

            df[deep] = klein[i];
            use[i] = true;

            dfs(deep + 1);

            use[i] = false;
        }

    }
}
