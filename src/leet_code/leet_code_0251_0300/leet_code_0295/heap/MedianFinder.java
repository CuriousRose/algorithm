package leet_code.leet_code_0251_0300.leet_code_0295.heap;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author chj
 * @date 2019/8/19 12:30
 */
class MedianFinder {

    Queue<Integer> maxQueue;
    Queue<Integer> minQueue;

    public MedianFinder() {
        maxQueue = new PriorityQueue<>();
        minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (maxQueue.isEmpty() || num > maxQueue.peek()) {
            maxQueue.add(num);
        } else {
            minQueue.add(num);
        }
        if (maxQueue.size() - minQueue.size() > 1) {
            minQueue.add(maxQueue.poll());
        }
        if (minQueue.size() - maxQueue.size() > 1) {
            maxQueue.add(minQueue.poll());
        }
    }

    public double findMedian() {
        if (maxQueue.size() > minQueue.size()) {
            return maxQueue.peek();
        }
        if (minQueue.size() > maxQueue.size()) {
            return minQueue.peek();
        }
        return (minQueue.peek() + maxQueue.peek()) / 2.0;
    }
}