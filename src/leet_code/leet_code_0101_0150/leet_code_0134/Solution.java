package leet_code.leet_code_0101_0150.leet_code_0134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i];
            sum -= cost[i];
            gas[i] -= cost[i];
        }
        if (sum < 0) {
            return -1;
        }

        int l = 0;
        int r = 0;
        sum = gas[l];
        while (r < gas.length) {
            if (sum >= 0) {
                r++;
                if (r == gas.length) {
                    break;
                }
                sum += gas[r];
            } else {
                sum -= gas[l];
                l++;
            }
        }
        return l;
    }
}
