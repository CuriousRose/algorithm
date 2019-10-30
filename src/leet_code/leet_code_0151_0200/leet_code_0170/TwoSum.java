package leet_code.leet_code_0151_0200.leet_code_0170;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数据结构
 */
class TwoSum {
    List<Integer> list;

    public TwoSum() {
        list = new ArrayList<>();
    }

    public void add(int number) {
        list.add(number);
    }

    public boolean find(int value) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (set.contains(value - list.get(i))) {
                return true;
            }
            set.add(list.get(i));
        }
        return false;
    }
}
