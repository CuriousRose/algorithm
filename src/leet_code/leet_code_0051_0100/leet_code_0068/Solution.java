package leet_code.leet_code_0051_0100.leet_code_0068;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
//        String[] words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        for (String s : solution.fullJustify(words, 16)) {
            System.out.println(s);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int len = 0;
        while (right < words.length) {
            int count = 0;
            while (right < words.length && len + words[right].length() + count <= maxWidth) {
                len += words[right].length();
                count++;
                right++;
            }

            int gap = count - 1;
            StringBuffer buffer = new StringBuffer();
            if (gap == 0) {
                buffer.append(words[left]);
                for (int i = len; i < maxWidth; i++) {
                    buffer.append(" ");
                }
            } else {
                if (right == words.length) {
                    for (int i = left; i < right; i++) {
                        buffer.append(words[i]);
                        if (i != right - 1) {
                            buffer.append(" ");
                        }
                    }
                    for (int i = len + gap; i < maxWidth; i++) {
                        buffer.append(" ");
                    }
                } else {
                    int space = maxWidth - len;
                    int gl = space / gap;
                    int sup = space - gl * gap;
                    for (int i = left; i < right; i++) {
                        buffer.append(words[i]);
                        if (i == right - 1) {
                            break;
                        }
                        for (int j = 0; j < gl; j++) {
                            buffer.append(" ");
                        }
                        if (sup-- > 0) {
                            buffer.append(" ");
                        }
                    }
                }
            }

            result.add(buffer.toString());
            left = right;
            len = 0;
        }
        return result;
    }
}