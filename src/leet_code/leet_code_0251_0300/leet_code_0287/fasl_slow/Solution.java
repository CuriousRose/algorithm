package leet_code.leet_code_0251_0300.leet_code_0287.fasl_slow;

/**
 * @author chj
 * @date 2019/8/15 11:55
 * 快慢指针 抽屉原理
 * 12:04
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        int index = 0;
        while (index != slow) {
            index = nums[index];
            slow = nums[slow];
        }
        return index;
    }
}