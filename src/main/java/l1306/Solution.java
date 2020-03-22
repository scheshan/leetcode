package l1306;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        addQueue(arr, queue, visited, start);

        while (!queue.isEmpty()) {
            int pos = queue.remove();
            if (arr[pos] == 0) {
                return true;
            }

            addQueue(arr, queue, visited, pos - arr[pos]);
            addQueue(arr, queue, visited, pos + arr[pos]);
        }
        return false;
    }

    private void addQueue(int[] arr, Queue<Integer> queue, Set<Integer> visited, int pos) {
        if (pos < 0 || pos >= arr.length) {
            return;
        }
        if (visited.contains(pos)) {
            return;
        }

        visited.add(pos);
        queue.add(pos);
    }
}
