package l215;

import java.util.PriorityQueue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() >= k) {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            } else {
                queue.add(num);
            }
        }

        return queue.peek();
    }
}
