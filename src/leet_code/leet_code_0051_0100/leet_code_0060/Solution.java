package leet_code.leet_code_0051_0100.leet_code_0060;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));
    }

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        find(nums, n - 1, k);
        StringBuffer buffer = new StringBuffer();
        for (int i : nums) {
            buffer.append(i);
        }
        return buffer.toString();
    }

    void find(int[] nums, int len, int aim) {
        if (aim <= 1) {
            return;
        }
        int head = len;
        int p = 1;
        int index = 1;
        while (index < aim) {
            head--;
            p++;
            index *= p;
        }
        index /= p;
        int k = (aim - 1) / index;
        int i = nums[head + k];
        for (int j = head + k; j > head && j > 0; j--) {
            nums[j] = nums[j - 1];
        }
        nums[head] = i;
        find(nums, len, aim - k * index);
    }
}