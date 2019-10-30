package leet_code.leet_code_0251_0300.leet_code_0273;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/12 10:39
 * 模拟 字符串
 * 12:05
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(1234567891));
    }

    String[] s1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
            , "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] s2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] s3 = {"Hundred", "Thousand", "Million", "Billion"};

    //1,234,567,891
    //One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuffer result = new StringBuffer();
        List<String> list = new ArrayList<>();

        if (num >= Math.pow(10, 9)) {
            int item = (int) (num / Math.pow(10, 9));
            list.addAll(parser(item));
            list.add(s3[3]);
            num %= Math.pow(10, 9);
        }

        if (num >= Math.pow(10, 6)) {
            int item = (int) (num / Math.pow(10, 6));
            list.addAll(parser(item));
            list.add(s3[2]);
            num %= Math.pow(10, 6);
        }

        if (num >= Math.pow(10, 3)) {
            int item = (int) (num / Math.pow(10, 3));
            list.addAll(parser(item));
            list.add(s3[1]);
            num %= Math.pow(10, 3);
        }

        if (num >= 0) {
            list.addAll(parser(num));
        }

        for (String s : list) {
            if (s.equals("")) {
                continue;
            }
            result.append(s).append(" ");
        }
        return result.toString().trim();
    }

    List<String> parser(int num) {
        List<String> list = new ArrayList<>();
        if (num >= 100) {
            list.add(s1[num / 100]);
            list.add(s3[0]);
        }
        num %= 100;
        if (num >= 20) {
            list.add(s2[num / 10]);
            list.add(s1[num % 10]);
        } else {
            list.add(s1[num]);
        }
        return list;
    }
}
