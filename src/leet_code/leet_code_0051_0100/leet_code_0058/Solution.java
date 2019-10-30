package leet_code.leet_code_0051_0100.leet_code_0058;

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] splits = s.split(" ");
        String last = splits[splits.length - 1];
        return last.length();
    }
}