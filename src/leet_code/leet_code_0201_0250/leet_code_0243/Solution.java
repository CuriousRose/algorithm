package leet_code.leet_code_0201_0250.leet_code_0243;

/**
 * @author chj
 * @date 2019/7/5 11:19
 * 模拟
 * 11:27
 */
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
                if (i1 >= 0 && i2 >= 0) {
                    min = Math.min(min, Math.abs(i1 - i2));
                }
            }
            if (words[i].equals(word2)) {
                i2 = i;
                if (i1 >= 0 && i2 >= 0) {
                    min = Math.min(min, Math.abs(i1 - i2));
                }
            }
        }
        return min;
    }
}