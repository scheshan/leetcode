package leetcode.p1429;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * FirstUnique
 *
 * @author heshan
 * @date 2023/2/4
 */
public class FirstUnique {

    private Queue<Integer> queue;

    private Map<Integer, Integer> count;

    public FirstUnique(int[] nums) {
        count = new HashMap<>();
        queue = new ArrayDeque<>(nums.length * 2);
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && count.get(queue.peek()) > 1) {
            queue.remove();
        }

        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    public void add(int value) {
        count.put(value, count.getOrDefault(value, 0) + 1);
        queue.add(value);
    }
}
