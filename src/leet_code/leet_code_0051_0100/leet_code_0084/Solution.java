package leet_code.leet_code_0051_0100.leet_code_0084;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = new int[]{5, 4, 1, 2};
        System.out.println(solution.largestRectangleArea(nums));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        return find(heights, 0, heights.length - 1);
    }

    int find(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int ml = (l + r) / 2;
        int mr = ml + 1;

        int max = Math.max(find(nums, l, ml), find(nums, mr, r));
        int h = Math.min(nums[ml], nums[mr]);
        int cur = h * 2;
        max = Math.max(max, cur);
        while (ml > l || mr < r) {
            if (ml == l) {
                mr++;
                h = Math.min(h, nums[mr]);
                cur = h * (mr - ml + 1);
                max = Math.max(max, cur);
                continue;
            }
            if (mr == r) {
                ml--;
                h = Math.min(h, nums[ml]);
                cur = h * (mr - ml + 1);
                max = Math.max(max, cur);
                continue;
            }
            if (nums[ml - 1] > nums[mr + 1]) {
                ml--;
                h = Math.min(h, nums[ml]);
            } else {
                mr++;
                h = Math.min(h, nums[mr]);
            }
            cur = h * (mr - ml + 1);
            max = Math.max(max, cur);
        }
        return max;
    }
}