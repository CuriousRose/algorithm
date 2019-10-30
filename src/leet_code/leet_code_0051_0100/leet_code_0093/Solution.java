package leet_code.leet_code_0051_0100.leet_code_0093;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "010010";
        for (String str : solution.restoreIpAddresses(s)) {
            System.out.println(str);
        }
    }

    List<String> result = new ArrayList<>();
    int[] list = new int[4];
    char[] cs;
    int len;

    public List<String> restoreIpAddresses(String s) {
        cs = s.toCharArray();
        len = cs.length;
        dfs(0, 0);
        return result;
    }

    void dfs(int index, int start) {
        if (index == 4) {
            if (start == len) {
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < 4; i++) {
                    buffer.append(list[i]);
                    if (i != 3) {
                        buffer.append(".");
                    }
                }
                result.add(buffer.toString());
            }
            return;
        }
        int sum = 0;
        for (int i = start; i < len; i++) {
            if (i > start && sum == 0) {
                break;
            }
            sum = sum * 10 + cs[i] - '0';
            if (sum > 255) {
                break;
            }
            list[index] = sum;
            dfs(index + 1, i + 1);
        }
    }
}