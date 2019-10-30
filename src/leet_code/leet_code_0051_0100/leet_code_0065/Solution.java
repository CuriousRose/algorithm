package leet_code.leet_code_0051_0100.leet_code_0065;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("-."));
    }

    public boolean isNumber(String s) {
        if (s.trim().length() == 0) {
            return false;
        }
        return checkNumber(s.trim());
    }

    boolean checkNumber(String s) {
        if (s.contains("e")) {
            if (s.indexOf("e") != s.lastIndexOf("e")) {
                return false;
            }
            String[] sp = s.split("e");
            if (sp.length != 2) {
                return false;
            }
            return checkFloat(sp[0]) && checkIndex(sp[1]);
        } else {
            return checkFloat(s);
        }
    }

    boolean checkFloat(String s) {
        boolean has = false;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                has = true;
            }
        }
        if (!has) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        if (s.contains(".")) {
            if (s.indexOf(".") != s.lastIndexOf(".")) {
                return false;
            }
            String[] sp = s.split("\\.");
            if (sp.length == 1) {
                return checkInt(sp[0]);
            }
            if (sp.length != 2) {
                return false;
            }
            if (sp[0].length() == 0) {
                return checkDecimal(sp[1]);
            } else {
                return checkInt(sp[0]) && checkDecimal(sp[1]);

            }
        } else {
            return checkInt(s);
        }
    }

    boolean checkInt(String s) {
        if (s.startsWith("-") || s.startsWith("+")) {
            s = s.substring(1);
        }
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    boolean checkIndex(String s) {
        if (s.startsWith("-") || s.startsWith("+")) {
            s = s.substring(1);
        }
        if (s.length() == 0) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    boolean checkDecimal(String s) {
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}