package leet_code.leet_code_0251_0300.leet_code_0299;

/**
 * @author chj
 * @date 2019/8/20 10:10
 * 模拟
 * 10:15
 */
class Solution {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int n[] = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                int index = secret.charAt(i) - '0';
                n[index]++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                continue;
            }
            int index = guess.charAt(i) - '0';
            if (n[index] > 0) {
                b++;
                n[index]--;
            }
        }
        return String.format("%dA%dB", a, b);
    }
}
