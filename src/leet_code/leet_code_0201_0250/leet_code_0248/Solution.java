package leet_code.leet_code_0201_0250.leet_code_0248;


/**
 * @author chj
 * @date 2019/8/5 9:42
 * 模拟 统计 搜索(深度优先)
 * 10:28
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strobogrammaticInRange("1001", "11111"));
    }

    public int strobogrammaticInRange(String low, String high) {
        left = low;
        right = high;
        int sum = 0;
        for (int i = low.length(); i <= high.length(); i++) {
            sum += findStrobogrammatic(i);
        }
        return sum;
    }


    char[] cs = {'0', '1', '6', '8', '9'};
    char[] ps = {'0', '1', '9', '8', '6'};
    char[] ms = {'0', '1', '8'};
    char[] list;
    int count = 0;
    String left;
    String right;

    int findStrobogrammatic(int n) {
        list = new char[n];
        count = 0;
        dfs(0, n - 1);
        return count;
    }

    void dfs(int index, int len) {
        if (index > (len - 1) / 2 || len == 0) {
            if (len % 2 == 0) {
                int mid = len / 2;
                for (int i = 0; i < ms.length; i++) {
                    list[mid] = ms[i];
                    String result = String.valueOf(list);
                    if (between(result)) {
                        count++;
                    }
                }
            } else {
                String result = String.valueOf(list);
                if (between(result)) {
                    count++;
                }
            }
            return;
        }
        int i = index == 0 ? 1 : 0;
        for (; i < cs.length; i++) {
            list[index] = cs[i];
            list[len - index] = ps[i];
            dfs(index + 1, len);
        }
    }

    boolean between(String s) {
        if (s.length() == left.length() && s.compareTo(left) < 0) {
            return false;
        }
        if (s.length() == right.length() && s.compareTo(right) > 0) {
            return false;
        }
        return true;
    }
}
