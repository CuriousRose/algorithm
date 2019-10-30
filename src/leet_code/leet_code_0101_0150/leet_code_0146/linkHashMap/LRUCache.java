package leet_code.leet_code_0101_0150.leet_code_0146.linkHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {

    int limit;

    public LRUCache(int capacity) {
        super(capacity, (float) 0.75, true);
        this.limit = capacity;
    }

    public int get(int key) {
        if (super.get(key) == null) {
            return -1;
        }
        return super.get(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > limit;
    }
}
