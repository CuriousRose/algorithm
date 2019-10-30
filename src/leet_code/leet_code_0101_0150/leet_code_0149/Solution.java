package leet_code.leet_code_0101_0150.leet_code_0149;

/**
 * 坐标 暴力
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = new int[][]{
                {-2, -1}, {5, 2}, {2, 5},
                {-1, 4}, {1, 5}, {2, -2},
                {5, -4}, {3, 4}, {-2, 4},
                {0, -5}, {0, -5}, {0, -8},
                {0, -12}, {0, -11}, {0, -9}};
        System.out.println(solution.maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int same = 1;
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    same++;
                } else {
                    long dx = points[i][0] - points[j][0];
                    long dy = points[i][1] - points[j][1];
                    count++;
                    for (int k = j + 1; k < n; k++) {
                        if (dy * (points[i][0] - points[k][0]) == dx * (points[i][1] - points[k][1])) {
                            count++;
                        }
                    }
                }
                max = Math.max(max, same + count);
            }
        }
        return max;
    }
}
