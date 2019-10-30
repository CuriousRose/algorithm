package leet_code.leet_code_0201_0250.leet_code_0223;

/**
 * @author chj
 * @date 2019/6/28 11:25
 * 模拟 坐标
 * 11:37
 */
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        System.out.println(area);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int button = Math.max(B, F);
        if (left >= right || button >= top) {
            return area;
        }
        return area - (right - left) * (top - button);
    }
}