package leet_code.leet_code_0001_0050.leet_code_0050;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(1 / x / x, -(n / 2));
            } else {
                return myPow(1 / x, -n);
            }
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2) * x;
        }
    }
}