package offer.p41;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class MedianFinder {

    private Queue<Integer> q1;

    private Queue<Integer> q2;

    public MedianFinder() {
        q1 = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        q2 = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
    }

    public void addNum(int num) {
        if (q1.size() == q2.size()) {
            if (q2.size() > 0 && num > q2.peek()) {
                q1.add(q2.remove());
                q2.add(num);
            } else {
                q1.add(num);
            }
        } else {
            if (q1.size() > 0 && num < q1.peek()) {
                q2.add(q1.remove());
                q1.add(num);
            } else {
                q2.add(num);
            }
        }
    }

    public double findMedian() {
        if (q1.size() == 0 && q2.size() == 0) {
            return 0;
        }

        if (q1.size() > q2.size()) {
            return q1.peek();
        }
        return (q1.peek() + q2.peek()) / 2.0;
    }
}
