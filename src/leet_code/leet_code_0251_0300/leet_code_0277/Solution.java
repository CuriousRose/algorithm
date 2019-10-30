package leet_code.leet_code_0251_0300.leet_code_0277;

/**
 * @author chj
 * @date 2019/8/13 10:51
 * 图论 搜索(剪枝)
 * 11:31
 */
public class Solution extends Relation {
    boolean[] mark;
    int[] count;

    public int findCelebrity(int n) {
        mark = new boolean[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            dfs(i, n);
        }
        for (int i = 0; i < n; i++) {
            if (mark[i]) {
                continue;
            }
            if (count[i] != n - 1) {
                continue;
            }
            boolean know = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (knows(i, j)) {
                    know = true;
                    break;
                }
            }
            if (know) {
                continue;
            }
            return i;
        }
        return -1;
    }

    void dfs(int p, int n) {
        if (mark[p]) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (p == i) {
                continue;
            }
            if (knows(i, p)) {
                count[p]++;
                mark[i] = true;
            } else {
                mark[p] = true;
                return;
            }
        }
    }
}

class Relation {
    boolean knows(int a, int b) {
        return false;
    }
}