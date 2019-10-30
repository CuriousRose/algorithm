package leet_code.leet_code_0251_0300.leet_code_0295;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/19 11:46
 * 数据结构 二分查找
 * 12:29
 */
class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if (list.isEmpty() || num >= list.get(list.size() - 1)) {
            list.add(num);
        } else {
            int index = binarySearch(num, 0, list.size() - 1);
            list.add(index, num);
        }
    }

    public double findMedian() {
        int mid = list.size() / 2;
        if (list.size() % 2 == 1) {
            return list.get(mid);
        } else {
            return (list.get(mid) + list.get(mid - 1)) / 2.0;
        }
    }

    int binarySearch(int aim, int l, int r) {
        if (l == r) {
            return l;
        }
        if (aim <= list.get(l)) {
            return l;
        }
        if (aim >= list.get(r)) {
            return r;
        }
        int m = (l + r) / 2;
        if (aim == list.get(m)) {
            return m;
        }
        if (aim < list.get(m)) {
            return binarySearch(aim, l, m);
        } else {
            return binarySearch(aim, m + 1, r);
        }
    }
}