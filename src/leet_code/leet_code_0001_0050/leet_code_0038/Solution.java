package leet_code.leet_code_0001_0050.leet_code_0038;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(30));
    }

    public String countAndSay(int n) {
        String s = "1";

        if (n == 1) {
            return s;
        }

        for (int i = 2; i <= n; i++) {
            StringBuffer buffer = new StringBuffer();

            char[] cs = s.toCharArray();

            int index = 1;
            int count = 1;

            while (index < cs.length) {
                if (cs[index] == cs[index - 1]) {
                    count++;
                    index++;
                } else {
                    buffer.append(count).append(cs[index - 1]);
                    count = 1;
                    index++;
                }
            }
            buffer.append(count).append(cs[index - 1]);
            s = buffer.toString();
        }

        return s;
    }
}
