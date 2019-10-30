package leet_code.leet_code_0101_0150.leet_code_0146;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希
 */
class LRUCache {
    int limit;
    int step = 0;
    Map<Integer, Record> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.limit = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        step++;
        Record record = map.get(key);
        record.step = step;
        return record.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key) && limit == map.size()) {
            Record record = null;
            for (Map.Entry<Integer, Record> entry : map.entrySet()) {
                if (record == null) {
                    record = entry.getValue();
                } else {
                    if (entry.getValue().step < record.step) {
                        record = entry.getValue();
                    }
                }
            }
            map.remove(record.key);
        }
        step++;
        Record record = new Record(key, value, step);
        map.put(key, record);
    }

    class Record {
        int key;
        int value;
        int step;

        Record(int key, int value, int step) {
            this.key = key;
            this.value = value;
            this.step = step;
        }
    }
}