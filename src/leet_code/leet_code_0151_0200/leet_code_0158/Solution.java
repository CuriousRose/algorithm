package leet_code.leet_code_0151_0200.leet_code_0158;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 模拟 读取
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    Queue<Character> queue = new LinkedList<>();

    public int read(char[] buf, int n) {
        char[] b = new char[4];
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                int k = read4(b);
                if (k == 0) {
                    return i;
                }
                for (int j = 0; j < k; j++) {
                    queue.add(b[j]);
                }
            }
            buf[i] = queue.poll();
        }
        return n;
    }
}

class Reader4 {
    int read4(char[] buf) {
        return 0;
    }
}