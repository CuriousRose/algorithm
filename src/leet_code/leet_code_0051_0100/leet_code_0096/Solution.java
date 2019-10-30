package leet_code.leet_code_0051_0100.leet_code_0096;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(18));
    }

    boolean[] mark;
    int[] record;

    public int numTrees(int n) {
        mark = new boolean[n + 1];
        record = new int[n + 1];
        return count(0, n - 1);
    }

    int count(int left, int right) {
        if (left >= right) {
            return 1;
        }
        if (record[right - left] != 0) {
            return record[right - left];
        }
        int count = 0;
        for (int i = left; i <= right; i++) {
            count += count(left, i - 1) * count(i + 1, right);
        }
        record[right - left] = count;
        return count;
    }
}