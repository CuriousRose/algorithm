package leet_code.leet_code_0251_0300.leet_code_0275;

/**
 * @author chj
 * @date 2019/8/13 10:18
 * 模拟
 * 10:19
 */
class Solution {
    public int hIndex(int[] citations) {
        for (int h = citations.length; h > 0; h--) {
            if (citations[citations.length - h] >= h) {
                return h;
            }
        }
        return 0;
    }
}