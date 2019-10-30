package leet_code.leet_code_0051_0100.leet_code_0056;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] interval : solution.merge(intervals)) {
            System.out.println(interval[0] + ":" + interval[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        List<Interval> intervalList = new ArrayList<>();
        for (int[] item : intervals) {
            intervalList.add(new Interval(item[0], item[1]));
        }
        intervalList.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.left == i2.left) {
                    return i1.right - i2.right;
                } else {
                    return i1.left - i2.left;
                }
            }
        });

        List<Interval> record = new ArrayList<>();
        Interval interval = intervalList.get(0);
        for (int i = 1; i < intervalList.size(); i++) {
            Interval item = intervalList.get(i);
            if (interval.right >= item.left) {
                interval.right = Math.max(interval.right, item.right);
            } else {
                record.add(interval);
                interval = item;
            }
        }
        record.add(interval);

        int[][] result = new int[record.size()][2];
        for (int i = 0; i < record.size(); i++) {
            interval = record.get(i);
            result[i][0] = interval.left;
            result[i][1] = interval.right;
        }
        return result;
    }

    class Interval {
        int left;
        int right;

        Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}