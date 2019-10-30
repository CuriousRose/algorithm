package leet_code.leet_code_0051_0100.leet_code_0076;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a";
        String t = "aa";
        System.out.println(solution.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length() == 0) {
            return "";
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] record = new int[128];
        int[] aim = new int[128];
        int total = 0;
        for (char c : ct) {
            total++;
            aim[c]++;
        }
        int min = cs.length + 1;
        int ml = 0;
        int mr = 0;
        int left = 0;
        int right = 0;
        int current = 0;
        while (right < cs.length) {
            while (current < total && right < cs.length) {
                char c = cs[right];
                if (record[c] < aim[c]) {
                    current++;
                }
                record[c]++;
                right++;
            }
            while (current >= total) {
                if (right - left < min) {
                    min = right - left;
                    ml = left;
                    mr = right;
                }

                char c = cs[left];
                if (record[c] <= aim[c]) {
                    current--;
                }
                record[c]--;
                left++;
            }
        }
        return s.substring(ml, mr);
    }
}