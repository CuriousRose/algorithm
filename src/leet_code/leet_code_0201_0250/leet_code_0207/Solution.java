package leet_code.leet_code_0201_0250.leet_code_0207;

import java.util.*;

/**
 * 图论 拓扑 深度优先
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] prerequisites = new int[][]{
                {0, 2},
                {1, 2},
                {2, 0}
        };
        System.out.println(solution.canFinish(3, prerequisites));
    }

    List<List<Integer>> link = new ArrayList<>();
    boolean[] start;
    boolean[] mark;
    int count = 0;
    boolean cyc;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len < 2) {
            return true;
        }
        for (int i = 0; i < numCourses; i++) {
            link.add(new ArrayList<>());
        }
        start = new boolean[numCourses];
        mark = new boolean[numCourses];
        for (int i = 0; i < len; i++) {
            link.get(prerequisites[i][0]).add(prerequisites[i][1]);
            start[prerequisites[i][1]] = true;
        }

        for (int i = 0; i < numCourses; i++) {
            if (start[i]) {
                continue;
            }
            record = new HashSet<>();
            mark[i] = true;
            count++;
            if (dfs(i)) {
                return false;
            }
        }
        return count == numCourses;
    }

    Set<Integer> record;

    boolean dfs(int k) {
        if (cyc) {
            return true;
        }
        record.add(k);
        for (int v : link.get(k)) {
            if (record.contains(v)) {
                cyc = true;
                return true;
            } else {
                if (!mark[v]) {
                    mark[v] = true;
                    count++;
                }
                if (dfs(v)) {
                    cyc = true;
                    return true;
                }
            }
        }
        record.remove(k);
        return false;
    }
}