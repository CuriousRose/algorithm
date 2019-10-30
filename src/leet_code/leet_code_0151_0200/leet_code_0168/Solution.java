package leet_code.leet_code_0151_0200.leet_code_0168;

/**
 * 模拟
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(1111111));
    }

    public String convertToTitle(int n) {
        char[] cs = new char[]{
                'Z', 'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z'
        };
        StringBuffer buffer = new StringBuffer();
        while (n > 0) {
            int m = n % 26;
            buffer.insert(0, cs[m]);
            n /= 26;
            if (m == 0) {
                n--;
            }
        }
        return buffer.toString();
    }
}
