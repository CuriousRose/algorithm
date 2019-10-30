package leet_code.leet_code_0201_0250.leet_code_0207.tp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 图论 拓扑排序
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] prerequisites = new int[][]{
                {1, 0},
                {2, 0}
        };
        System.out.println(solution.canFinish(3, prerequisites));
    }

    List<Set<Integer>> link = new ArrayList<>();
    List<Set<Integer>> back = new ArrayList<>();
    Set<Integer> set = new HashSet<>();


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len < 2) {
            return true;
        }
        for (int i = 0; i < numCourses; i++) {
            set.add(i);
            link.add(new HashSet<>());
            back.add(new HashSet<>());
        }
        for (int i = 0; i < len; i++) {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            link.get(x).add(y);
            back.get(y).add(x);
        }
        while (!set.isEmpty()) {
            List<Integer> remove = new ArrayList<>();
            for (int i : set) {
                if (back.get(i).size() == 0) {
                    for (int j : link.get(i)) {
                        back.get(j).remove(i);
                    }
                    remove.add(i);
                }
            }
            if (remove.isEmpty()) {
                break;
            } else {
                for (int i : remove) {
                    set.remove(i);
                }
            }
        }
        return set.isEmpty();
    }
}
