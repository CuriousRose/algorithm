package leet_code.leet_code_0201_0250.leet_code_0201.good;

class Solution {
    int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        for (; m != n; ++offset) {
            m >>= 1;
            n >>= 1;
        }
        return n << offset;
    }
}