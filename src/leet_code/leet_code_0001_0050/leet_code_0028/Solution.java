package leet_code.leet_code_0001_0050.leet_code_0028;

class Solution {
    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issip";
//        String s1 = "aabaaabaaac";
//        String s2 = "aabaaac";
        Solution solution = new Solution();
        System.out.println(solution.strStr(s1, s2));
    }

    public int strStr(String haystack, String needle) {
        int[] prefix = new int[needle.length()];
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();

        if (ns.length == 0) {
            return 0;
        }

        int index = 0;
        int k = 1;
        while (k < ns.length) {
            if (ns[index] == ns[k]) {
                index++;
                prefix[k] = index;
                k++;
                continue;
            }
            if (index > 0) {
                index = prefix[index - 1];
            } else {
                k++;
            }
        }

        index = 0;
        k = 0;
        while (k < hs.length) {
            if (ns[index] == hs[k]) {
                index++;
                k++;
                if (index == ns.length) {
                    return k - index;
                }
                continue;
            }
            if (index > 0) {
                index = prefix[index - 1];
            } else {
                k++;
            }
        }
        return -1;
    }

}