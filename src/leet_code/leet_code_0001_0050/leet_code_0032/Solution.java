package leet_code.leet_code_0001_0050.leet_code_0032;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")(((((()())()()))()(()))("));
    }

    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int max = 0;

        Queue<Integer> lq = new LinkedList<>();
        Queue<Integer> rq = new LinkedList<>();

        for (int i = 1; i < cs.length; i++) {
            if (cs[i - 1] == '(' && cs[i] == ')') {
                lq.add(i - 1);
                rq.add(i);
                max = 2;
            }
        }

        if (lq.isEmpty()) {
            return 0;
        }

        boolean change = true;
        while (change) {
            change = false;

            int len = lq.size();
            while (len > 0) {

                int l = lq.poll();
                int r = rq.poll();
                len--;

                while (!lq.isEmpty()) {
                    int nl = lq.peek();
                    int nr = rq.peek();

                    if (nl - r == 1) {
                        r = nr;
                        max = max > r - l + 1 ? max : r - l + 1;
                        lq.poll();
                        rq.poll();
                        len--;
                        change = true;
                    } else {
                        break;
                    }
                }

                while (l > 0 && r < s.length() - 1) {
                    if (cs[l - 1] == '(' && cs[r + 1] == ')') {
                        l--;
                        r++;
                        max = max > r - l + 1 ? max : r - l + 1;
                        change = true;
                    } else {
                        break;
                    }
                }
                
                lq.add(l);
                rq.add(r);
            }
        }

        return max;
    }
}