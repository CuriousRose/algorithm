package leet_code.leet_code_0001_0050.leet_code_0007;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(120));
    }

    public int reverse(int x) {
        long in = x;
        long out = 0;

        boolean negative = in < 0;
        if (negative) {
            in = -in;
        }

        String s = String.valueOf(in);
        long p = 1;
        for (int i = 0; i < s.length(); i++) {
            out += (s.charAt(i) - '0') * p;
            p *= 10;
        }

        if (negative) {
            out = -out;
        }

        if (out < 0x80000000 || out > 0x7fffffff) {
            return 0;
        }
        return (int) out;
    }
}