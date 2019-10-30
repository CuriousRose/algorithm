package leet_code.leet_code_0151_0200.leet_code_0157;


/**
 * 模拟 读取
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] b = new char[4];
        int sum = 0;
        for (int i = 0; i <= n; i += 4) {
            int k = read4(b);
            for (int j = 0; j < k; j++) {
                buf[sum + j] = b[j];
            }
            sum += k;
        }
        return sum < n ? sum : n;
    }
}

class Reader4 {
    int read4(char[] buf) {
        return 0;
    }
}