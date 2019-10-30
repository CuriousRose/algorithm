package leet_code.leet_code_0101_0150.leet_code_0122;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int sum = 0;
        int head = 0;
        int last = 0;
        while (last < len - 1) {
            if (prices[last] < prices[last + 1]) {
                last++;
                continue;
            } else {
                sum += prices[last] - prices[head];
                head = last + 1;
                last = head;
            }
        }
        sum += prices[last] - prices[head];
        return sum;
    }
}