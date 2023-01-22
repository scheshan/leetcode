package offer2.p059;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class KthLargest {

    private Queue<Integer> queue;

    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.remove();
            queue.add(val);
        }
        return queue.peek();
    }
}
