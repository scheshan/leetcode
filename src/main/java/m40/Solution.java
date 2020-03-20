package m40;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/20
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];

        if (k == 0) {
            return result;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (num < queue.peek()) {
                    queue.remove();
                    queue.add(num);
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = queue.remove();
        }

        return result;
    }
}
