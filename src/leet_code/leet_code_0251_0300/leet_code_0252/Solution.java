package leet_code.leet_code_0251_0300.leet_code_0252;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/5 11:46
 * 模拟 排序
 * 11:53
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        List<Time> timeList = new ArrayList<>();
        for (int[] is : intervals) {
            timeList.add(new Time(is[0], is[1]));
        }
        timeList.sort(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.left - o2.left;
            }
        });
        for (int i = 1; i < timeList.size(); i++) {
            if (timeList.get(i).left < timeList.get(i - 1).right) {
                return false;
            }
        }
        return true;
    }

    class Time {
        int left;
        int right;

        Time(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
