package leet_code.leet_code_0251_0300.leet_code_0255;

/**
 * @author chj
 * @date 2019/8/6 10:42
 * 遍历 二叉搜索树
 * 11:34
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifyPreorder(new int[]{5, 2, 6, 1, 3}));
    }

    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return true;
        }
        return build(preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
    }

    int index = 1;

    boolean build(Integer p, Integer l, Integer r, int[] preorder) {
        if (index == preorder.length) {
            return true;
        }
        int item = preorder[index];
        if (item < p) {
            if (item < l) {
                return false;
            }
            index++;
            if (build(item, l, p, preorder)) {
                return true;
            } else {
                item = preorder[index];
            }
        }
        if (item > p) {
            if (item > r) {
                return false;
            }
            index++;
            if (build(item, p, r, preorder)) {
                return true;
            }
        }
        return false;
    }
}