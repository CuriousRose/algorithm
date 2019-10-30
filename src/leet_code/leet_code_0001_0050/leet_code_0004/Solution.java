package leet_code.leet_code_0001_0050.leet_code_0004;


class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{5, 6, 7, 8, 9, 10};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aim = (nums1.length + nums2.length + 1) / 2 - 1;
        double sum = find(new Array(nums1), new Array(nums2), aim);
        if ((nums1.length + nums2.length) % 2 == 0) {
            sum += find(new Array(nums1), new Array(nums2), aim + 1);
            return sum / 2;
        } else {
            return sum;
        }

    }

    double find(Array ar1, Array ar2, int aim) {

        if (ar1.len() < ar2.len()) {
            return find(ar2, ar1, aim);
        }

        if (ar2.len() == 0) {
            return ar1.get(aim);
        }

        int index = ar1.len() / 2;
        int mid = ar1.get(index);
        int count = ar2.countLess(mid, ar2.left, ar2.right);

        if (index + count == aim) {
            return mid;
        }

        if (index + count > aim) {
            ar1.down(ar1.left + index - 1);
            ar2.down(ar2.left + count - 1);
        }

        if (index + count < aim) {
            aim -= ar1.up(ar1.left + index + 1);
            aim -= ar2.up(ar2.left + count);
        }

        return find(ar1, ar2, aim);
    }

    class Array {
        int[] num;
        int left, right;

        Array(int[] num) {
            this.num = num;
            this.left = 0;
            this.right = num.length - 1;
        }

        int getNext() {
            return num[right + 1];
        }

        int get(int i) {
            return num[left + i];
        }

        int len() {
            return right - left + 1;
        }

        int countLess(int i, int l, int r) {
            if (l > r) {
                return 0;
            }

            if (l == r) {
                if (num[l] < i) {
                    return 1;
                } else {
                    return 0;
                }
            }

            int m = (r + l + 1) / 2;
            if (num[m] == i) {
                return m - l;
            }

            if (i < num[m]) {
                return countLess(i, l, m - 1);
            } else {
                return countLess(i, m, r) + m - l;
            }
        }

        int up(int m) {
            int leftRecord = left;
            left = m;
            return left - leftRecord;
        }

        void down(int m) {
            right = m;
        }
    }
}