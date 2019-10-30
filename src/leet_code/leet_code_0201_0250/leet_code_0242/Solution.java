package leet_code.leet_code_0201_0250.leet_code_0242;


/**
 * @author chj
 * @date 2019/7/5 10:55
 * 哈希
 * 10:59
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            if (count[index] == 0) {
                return false;
            } else {
                count[index]--;
            }
        }
        return true;
    }
}
