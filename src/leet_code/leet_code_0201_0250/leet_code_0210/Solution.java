package leet_code.leet_code_0201_0250.leet_code_0210;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 图论 拓扑排序
 */
class Solution {
    List<Set<Integer>> link = new ArrayList<>();
    List<Set<Integer>> back = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int[] result;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            link.add(new HashSet<>());
            back.add(new HashSet<>());
            set.add(i);
        }
        for (int[] is : prerequisites) {
            link.get(is[1]).add(is[0]);
            back.get(is[0]).add(is[1]);
        }
        int count = 0;
        result = new int[numCourses];
        while (!set.isEmpty()) {
            List<Integer> record = new ArrayList<>();
            for (int i : set) {
                if (back.get(i).isEmpty()) {
                    record.add(i);
                    for (int j : link.get(i)) {
                        back.get(j).remove(i);
                    }
                }
            }
            if (record.isEmpty()) {
                break;
            } else {
                for (int i : record) {
                    result[count++] = i;
                    set.remove(i);
                }
            }
        }

        if (set.isEmpty()) {
            return result;
        } else {
            return new int[0];
        }
    }
}