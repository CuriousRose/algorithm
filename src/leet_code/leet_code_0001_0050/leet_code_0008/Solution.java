package leet_code.leet_code_0001_0050.leet_code_0008;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("  0000000000012345678"));
    }

    public int myAtoi(String str) {
        boolean negative = false;
        boolean start = false;

        char[] cs = str.toCharArray();
        int[] ns = new int[20];
        int index = 0;

        for (char c : cs) {
            if (!start && c == ' ') {
                continue;
            }

            if (!start) {
                if (c == '-') {
                    negative = true;
                    start = true;
                    continue;
                }

                if (c == '+') {
                    start = true;
                    continue;
                }

                if (c >= '0' && c <= '9') {
                    start = true;
                } else {
                    break;
                }
            }

            if (start) {
                if (c >= '0' && c <= '9') {
                    if (index == 0 && c == '0') {
                        continue;
                    }

                    ns[index++] = c - '0';
                    if (index > 15) {
                        if (negative) {
                            return 0x80000000;
                        } else {
                            return 0x7fffffff;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        long out = 0;
        long p = 1;
        while (index > 0) {
            out += ns[--index] * p;
            p *= 10;
        }

        if (negative) {
            out = -out;
        }

        if (out < 0x80000000) {
            return 0x80000000;
        }

        if (out > 0x7fffffff) {
            return 0x7fffffff;
        }

        return (int) out;
    }
}
