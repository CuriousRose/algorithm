package leet_code.leet_code_0251_0300.leet_code_0284;

import java.util.Iterator;

/**
 * @author chj
 * @date 2019/8/15 11:01
 * 数据结构 迭代器 列表
 * 11:06
 */
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer cache = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (cache == null) {
            cache = iterator.next();
        }
        return cache;
    }

    @Override
    public Integer next() {
        if (cache == null) {
            return iterator.next();
        } else {
            int c = cache;
            cache = null;
            return c;
        }
    }

    @Override
    public boolean hasNext() {
        return cache != null || iterator.hasNext();
    }
}