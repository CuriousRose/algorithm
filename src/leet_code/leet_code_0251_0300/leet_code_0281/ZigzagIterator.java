package leet_code.leet_code_0251_0300.leet_code_0281;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/14 10:15
 * 模拟 列表
 * 10:26
 */
public class ZigzagIterator {

    int index = 0;
    List<Integer> list = new ArrayList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int i1 = 0, i2 = 0;
        while (i1 < v1.size() || i2 < v2.size()) {
            if (i1 < v1.size()) {
                list.add(v1.get(i1++));
            }
            if (i2 < v2.size()) {
                list.add(v2.get(i2++));
            }
        }
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}