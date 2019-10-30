package leet_code.leet_code_0201_0250.leet_code_0246;

/**
 * @author chj
 * @date 2019/8/2 10:28
 * 模拟
 * 10:36
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isStrobogrammatic("69"));
    }

    public boolean isStrobogrammatic(String num) {
        StringBuffer buffer = new StringBuffer();
        for (char c : num.toCharArray()) {
            if (c == '0') {
                buffer.append('0');
                continue;
            }
            if (c == '1') {
                buffer.append('1');
                continue;
            }
            if (c == '6') {
                buffer.append('9');
                continue;
            }
            if (c == '8') {
                buffer.append('8');
                continue;
            }
            if (c == '9') {
                buffer.append('6');
                continue;
            }
            return false;
        }
        buffer = buffer.reverse();
        return num.equals(buffer.toString());
    }
}