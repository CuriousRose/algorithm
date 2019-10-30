package leet_code.leet_code_0051_0100.leet_code_0071;

import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/..///"));
    }

    public String simplifyPath(String path) {
        LinkedList<String> linkedList = new LinkedList<>();
        String[] sp = path.split("/");
        for (String s : sp) {
            if (s.length() == 0) {
                continue;
            }
            if (s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!linkedList.isEmpty()) {
                    linkedList.removeLast();
                }
            } else {
                linkedList.addLast(s);
            }
        }
        if (linkedList.isEmpty()) {
            return "/";
        }
        StringBuffer buffer = new StringBuffer();
        for (String s : linkedList) {
            buffer.append("/").append(s);
        }
        return buffer.toString();
    }
}