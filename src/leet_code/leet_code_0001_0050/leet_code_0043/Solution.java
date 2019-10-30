package leet_code.leet_code_0001_0050.leet_code_0043;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("2", "3"));
    }

    public String multiply(String num1, String num2) {
        int[] n1 = new int[num1.length()];
        int[] n2 = new int[num2.length()];
        int[] ns = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            n1[i] = num1.charAt(i) - '0';
        }

        for (int i = 0; i < num2.length(); i++) {
            n2[i] = num2.charAt(i) - '0';
        }

        int len = num1.length() + num2.length() - 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                ns[len - i - j - 1] += n1[i] * n2[j];
            }
        }


        int head = 0;
        while (head < len) {
            ns[head + 1] += ns[head] / 10;
            ns[head] %= 10;
            head++;
        }

        while (head > 0) {
            if (ns[head] > 0) {
                break;
            }
            head--;
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = head; i >= 0; i--) {
            buffer.append(ns[i]);
        }
        return buffer.toString();
    }
}