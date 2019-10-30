package leet_code.leet_code_0051_0100.leet_code_0069;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(1));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        long xx = x;
        long index = x;
        while (xx / index <= index) {
            index /= 2;
        }
        while (index * index <= xx) {
            index++;
        }
        return (int) (index - 1);
    }
}