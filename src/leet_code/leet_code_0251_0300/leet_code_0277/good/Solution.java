package leet_code.leet_code_0251_0300.leet_code_0277.good;

/**
 * @author chj
 * @date 2019/8/13 11:34
 * 双指针
 */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (knows(l, r)) {
                l++;
            } else {
                r--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == l) {
                continue;
            }
            if (knows(i, l) && !knows(l, i)) {
                continue;
            }
            return -1;
        }
        return l;
    }
}

class Relation {
    boolean knows(int a, int b) {
        return false;
    }
}
