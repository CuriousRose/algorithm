package leet_code.leet_code_0251_0300.leet_code_0278;

/**
 * @author chj
 * @date 2019/8/13 11:37
 * 二分
 * 11:47
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        return find(1, n);
    }

    int find(long l, long r) {
        if (l == r) {
            return (int) l;
        }
        long mid = (l + r) / 2;
        if (isBadVersion((int) mid)) {
            return find(l, mid);
        } else {
            return find(mid + 1, r);
        }
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}