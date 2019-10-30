package leet_code.leet_code_0101_0150.leet_code_0132;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
//        String s = "aabbc";
        String s = "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
//        String s = "aaabbaaacaa";
        System.out.println(solution.minCut(s));
    }

    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (check(s.substring(0, i + 1))) {
                dp[i] = 0;
                continue;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            for (int j = i - 1; j >= 1; j--) {
                if (check(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    boolean check(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}