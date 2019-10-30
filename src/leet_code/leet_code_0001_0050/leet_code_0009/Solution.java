package leet_code.leet_code_0001_0050.leet_code_0009;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int[] ns = new int[20];
        int index = 0;
        int y = x;

        while (y > 0) {
            ns[index++] = y % 10;
            y /= 10;
        }

        for (int i = 0; i < index / 2; i++) {
            if (ns[i] != ns[index - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
