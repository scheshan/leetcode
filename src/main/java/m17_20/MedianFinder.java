package m17_20;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * MedianFinder
 *
 * @author heshan
 * @date 2020/4/29
 */
public class MedianFinder {

    private Queue<Integer> minQueue;

    private Queue<Integer> maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        maxQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minQueue.size() == 0) {
            minQueue.add(num);
        } else {
            int min = minQueue.peek();

            if (num < min) {
                minQueue.add(num);

                if (minQueue.size() > maxQueue.size() + 1) {
                    maxQueue.add(minQueue.remove());
                }
            } else {
                maxQueue.add(num);

                if (maxQueue.size() > minQueue.size()) {
                    minQueue.add(maxQueue.remove());
                }
            }
        }
    }

    public double findMedian() {
        if (minQueue.size() == 0 && maxQueue.size() == 0) {
            return 0;
        }

        if (minQueue.size() > maxQueue.size()) {
            return minQueue.peek();
        } else {
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
        }
    }
}
