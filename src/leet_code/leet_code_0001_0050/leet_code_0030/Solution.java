package leet_code.leet_code_0001_0050.leet_code_0030;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "goodwordgoodgoodgoodbestwordgood";
//        String[] words = new String[]{"word", "good", "good", "good", "best", "word", "good"};
//        String s = "barfoothefoobarman";
//        String[] words = new String[]{"foo", "bar"};
//        String s = "barfoofoobarthefoobarman";
//        String[] words = new String[]{"bar", "foo", "the"};
//        String s = "aaaaaaaa";
//        String[] words = new String[]{"aa", "aa", "aa"};
        String s = "ababaab";
        String[] words = new String[]{"ab", "ba", "ba"};
        System.out.println(solution.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0) {
            return list;
        }

        int wl = words[0].length();

        if (s.length() < wl) {
            return list;
        }

        int[] count = new int[words.length];
        Arrays.sort(words);
        int len = 0;
        int num = 1;
        for (int k = 1; k < words.length; k++) {
            if (words[k].equals(words[k - 1])) {
                num++;
            } else {
                words[len] = words[k - 1];
                count[len] = num;
                len++;
                num = 1;
            }
        }
        words[len] = words[words.length - 1];
        count[len] = num;

        Queue<Integer> queue = new LinkedList<>();
        int match = 0;

        for (int head = 0; head <= s.length() - wl * words.length; head++) {
            while (!queue.isEmpty()) {
                count[queue.poll()]++;
            }

            match = 0;
            int l = head;
            int r = l + wl;

            while (r <= s.length()) {
                String sub = s.substring(l, r);
                int find = find(words, 0, len, sub);
                if (find < 0) {
                    break;
                } else {
                    if (count[find] > 0) {
                        count[find]--;
                        queue.add(find);
                        match++;

                        if (match == words.length) {
                            list.add(head);
                            break;
                        } else {
                            l = r;
                            r = l + wl;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return list;
    }

    int find(String[] words, int l, int r, String aim) {
        if (l > r) {
            return -1;
        }

        if (l == r) {
            if (words[l].equals(aim)) {
                return l;
            } else {
                return -1;
            }
        }

        int m = (l + r) / 2;
        if (words[m].equals(aim)) {
            return m;
        }

        if (aim.compareTo(words[m]) < 0) {
            return find(words, l, m, aim);
        } else {
            return find(words, m + 1, r, aim);
        }
    }
}