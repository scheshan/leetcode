package l703;

import java.util.PriorityQueue;

/**
 * KthLargest
 *
 * @author heshan
 * @date 2020/3/24
 */
public class KthLargest {

    private PriorityQueue<Integer> queue;

    private int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else {
            if (val > queue.peek()) {
                queue.remove();
                queue.add(val);
            }
        }

        if (queue.size() == k) {
            return queue.peek();
        }

        return -1;
    }
}
