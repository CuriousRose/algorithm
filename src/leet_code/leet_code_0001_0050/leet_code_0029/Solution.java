package leet_code.leet_code_0001_0050.leet_code_0029;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(7, -3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (divisor == 0) {
            return -1;
        }

        boolean negative = dividend < 0 ^ divisor < 0;

        long xx = dividend;
        long yy = divisor;

        if (xx < 0) {
            xx = -xx;
        }

        if (yy < 0) {
            yy = -yy;
        }

        long x = xx;
        long y = yy;
        long z = 0;
        long k = 1;

        while (x > 0) {
            while (x > y << 1) {
                y <<= 1;
                k <<= 1;
            }
            if (x < y) {
                break;
            }
            x -= y;
            z += k;
            y = yy;
            k = 1;
        }

        z = negative ? -z : z;

        if (z < 0x80000000) {
            return 0x80000000;
        }

        if (z > 0x7fffffff) {
            return 0x7fffffff;
        }

        return (int) z;
    }
}