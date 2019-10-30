package leet_code.leet_code_0201_0250.leet_code_0245;

/**
 * @author chj
 * @date 2019/8/2 10:15
 * 模拟
 * 10:26
 */
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = words.length;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word1.equals(word2)) {
                if (word.equals(word1)) {
                    if (index1 < index2) {
                        index1 = i;
                    } else {
                        index2 = i;
                    }
                    if (index1 >= 0 && index2 >= 0) {
                        min = Math.min(min, Math.abs(index1 - index2));
                    }
                }
            } else {
                if (word1.equals(word)) {
                    index1 = i;
                    if (index1 >= 0 && index2 >= 0) {
                        min = Math.min(min, index1 - index2);
                    }
                }
                if (word2.equals(word)) {
                    index2 = i;
                    if (index1 >= 0 && index2 >= 0) {
                        min = Math.min(min, index2 - index1);
                    }
                }
            }
        }
        return min;
    }
}