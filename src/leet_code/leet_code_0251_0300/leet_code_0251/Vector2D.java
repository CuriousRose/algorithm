package leet_code.leet_code_0251_0300.leet_code_0251;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/5 11:43
 * 模拟
 * 11:45
 */
class Vector2D {
    List<Integer> list = new ArrayList<>();
    int index = 0;

    public Vector2D(int[][] v) {
        for (int[] is : v) {
            for (int i : is) {
                list.add(i);
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
