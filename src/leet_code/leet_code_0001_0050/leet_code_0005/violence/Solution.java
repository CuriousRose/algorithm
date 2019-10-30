package leet_code.leet_code_0001_0050.leet_code_0005.violence;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {

        String result = "";
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            {
                int c = 1;
                int l = i - 1, r = i + 1;
                while (l >= 0 && r < s.length()) {
                    if (s.charAt(l) == s.charAt(r)) {
                        c += 2;
                        l--;
                        r++;
                    } else {
                        break;
                    }
                }
                if (c > max) {
                    max = c;
                    result = s.substring(l + 1, r);
                }
            }

            {
                int c = 0;
                int l = i, r = i + 1;
                while (l >= 0 && r < s.length()) {
                    if (s.charAt(l) == s.charAt(r)) {
                        c += 2;
                        l--;
                        r++;
                    } else {
                        break;
                    }

                }
                if (c > max) {
                    max = c;
                    result = s.substring(l + 1, r);
                }
            }

        }

        return result;
    }
}