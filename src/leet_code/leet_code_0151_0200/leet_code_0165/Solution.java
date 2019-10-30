package leet_code.leet_code_0151_0200.leet_code_0165;

/**
 * 字符串 比较
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("0.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] sp1 = version1.split("\\.");
        String[] sp2 = version2.split("\\.");
        int index = 0;
        while (index < sp1.length || index < sp2.length) {
            int i = index < sp1.length ? Integer.parseInt(sp1[index]) : 0;
            int j = index < sp2.length ? Integer.parseInt(sp2[index]) : 0;
            if (i > j) {
                return 1;
            }
            if (i < j) {
                return -1;
            }
            index++;
        }
        return 0;
    }
}