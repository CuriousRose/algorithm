package leet_code.leet_code_0251_0300.leet_code_0271;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/12 9:53
 * 模拟 字符串
 * 10:28
 */
public class Codec {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for (String str : strs) {
            str = str + "_";
            buffer.append(str).append(",;'");
        }
        return buffer.toString();
    }

    public List<String> decode(String s) {
        if (s.equals("")) {
            return new ArrayList<>();
        }
        String[] ss = s.split(",;'");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            list.add(ss[i].substring(0, ss[i].length() - 1));
        }
        return list;
    }
}