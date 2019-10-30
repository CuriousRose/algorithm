package leet_code.leet_code_0001_0050.leet_code_0012;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(4));
//      MCMXCIV
//      MCMXCIV
    }

    public String intToRoman(int num) {
        StringBuffer buffer = new StringBuffer();
        char[][] cs = new char[][]{{'I', 'V'}, {'X', 'L'}, {'C', 'D'}, {'M'}};

        int[] ns = new int[5];
        int l = 0;
        while (num > 0) {
            ns[l++] = num % 10;
            num /= 10;
        }

        for (int i = --l; i >= 0; i--) {
            if (ns[i] == 4) {
                buffer.append(cs[i][0]).append(cs[i][1]);
            } else if (ns[i] == 9) {
                buffer.append(cs[i][0]).append(cs[i + 1][0]);
            } else {
                if (ns[i] >= 5) {
                    buffer.append(cs[i][1]);
                    ns[i] -= 5;
                }
                for (int j = 0; j < ns[i]; j++) {
                    buffer.append(cs[i][0]);
                }
            }
        }
        return buffer.toString();
    }
}