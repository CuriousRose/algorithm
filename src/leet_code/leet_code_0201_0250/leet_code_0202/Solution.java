package leet_code.leet_code_0201_0250.leet_code_0202;

import java.util.HashSet;
import java.util.Set;

/**
 * 模拟
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(2));
    }

    public boolean isHappy(int n) {
        int sum = n;
        Set<Integer> set = new HashSet<>();
        while (sum != 1) {
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            String str = String.valueOf(sum);
            sum = 0;
            for (char c : str.toCharArray()) {
                int i = Integer.parseInt(String.valueOf(c));
                sum += i * i;
            }
        }
        return true;
    }
}