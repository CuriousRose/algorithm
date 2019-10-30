package leet_code.leet_code_0251_0300.leet_code_0253;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/5 11:53
 * 模拟 排序 贪心
 * 12:04
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        List<Time> timeList = new ArrayList<>();
        List<Integer> roomList = new ArrayList<>();
        for (int[] is : intervals) {
            timeList.add(new Time(is[0], is[1]));
        }
        timeList.sort(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.left - o2.left;
            }
        });
        roomList.add(timeList.get(0).right);
        item:
        for (int i = 1; i < timeList.size(); i++) {
            Time time = timeList.get(i);
            for (int j = 0; j < roomList.size(); j++) {
                if (time.left >= roomList.get(j)) {
                    roomList.set(j, time.right);
                    continue item;
                }
            }
            roomList.add(time.right);
        }
        return roomList.size();
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