package leet_code.leet_code_0101_0150.leet_code_0135;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ratings = new int[]{1, 2, 2};
        System.out.println(solution.candy(ratings));
    }

    public int candy(int[] ratings) {
        int len = ratings.length;
        Child[] children = new Child[len];
        for (int i = 0; i < len; i++) {
            children[i] = new Child(i, ratings[i]);
        }
        Arrays.sort(children);
        int[] count = new int[len];
        int sum = 0;

        for (Child child : children) {
            int index = child.index;
            int max = 0;
            if (index > 0 && ratings[index] > ratings[index - 1]) {
                max = Math.max(max, count[index - 1]);
            }
            if (index < len - 1 && ratings[index] > ratings[index + 1]) {
                max = Math.max(max, count[index + 1]);
            }
            count[index] = max + 1;
            sum += count[index];
        }
        return sum;
    }

    class Child implements Comparable<Child> {
        int index;
        int score;

        Child(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Child o) {
            return this.score - o.score;
        }
    }
}
