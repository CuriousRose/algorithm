package leet_code.leet_code_0051_0100.leet_code_0088;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n;
        while (m > 0 || n > 0) {
            if (m == 0) {
                nums1[--index] = nums2[--n];
                continue;
            }

            if (n == 0) {
                nums1[--index] = nums1[--m];
                continue;
            }

            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[--index] = nums1[--m];
            } else {
                nums1[--index] = nums2[--n];
            }
        }
    }
}
