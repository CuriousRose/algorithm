package leet_code.leet_code_0251_0300.leet_code_0267;

import java.util.*;

/**
 * @author chj
 * @date 2019/8/8 10:01
 * 哈希 搜索(深度优先) 剪枝
 * 10:51
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generatePalindromes("aaabbba"));
    }

    List<String> result = new ArrayList<>();
    Set<String> resultSet = new HashSet<>();
    List<Character> characterList = new ArrayList<>();
    Character mid = null;
    char[] cs;

    public List<String> generatePalindromes(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                characterList.add(c);
            } else {
                set.add(c);
            }
        }
        if (set.size() > 1) {
            return result;
        }
        for (Character c : set) {
            mid = c;
        }
        cs = new char[s.length()];
        characterList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });
        mark = new boolean[characterList.size()];
        dfs(0, characterList.size(), s.length() - 1);
        for (String str : resultSet) {
            result.add(str);
        }
        return result;
    }

    boolean[] mark;

    void dfs(int index, int len, int last) {
        if (index == len) {
            if (mid != null) {
                cs[len] = mid;
            }
            resultSet.add(String.valueOf(cs));
            return;
        }
        Character before = null;
        for (int i = 0; i < len; i++) {
            if (mark[i]) {
                continue;
            }
            if (characterList.get(i) == before) {
                continue;
            }
            before = characterList.get(i);
            cs[index] = characterList.get(i);
            cs[last - index] = characterList.get(i);
            mark[i] = true;
            dfs(index + 1, len, last);
            mark[i] = false;
        }
    }
}