package leet_code.leet_code_0251_0300.leet_code_0264;


/**
 * @author chj
 * @date 2019/8/7 11:20
 * 模拟 递推
 * 11:52
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(1690));
    }

    public int nthUglyNumber(int n) {
        int a = 1, b = 1, c = 1;
        long aa = 2, bb = 3, cc = 5;
        long[] list = new long[n + 1];
        list[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (aa < bb && aa < cc) {
                list[i] = aa;
                do {
                    aa = list[++a] * 2;

                } while (aa == bb || aa == cc);
                continue;
            }
            if (bb < aa && bb < cc) {
                list[i] = bb;
                do {
                    bb = list[++b] * 3;

                } while (bb == aa || bb == cc);
                continue;
            }
            if (cc < aa && cc < bb) {
                list[i] = cc;
                do {
                    cc = list[++c] * 5;

                } while (cc == aa || cc == bb);
                continue;
            }
        }
        return (int) list[n];
    }
}