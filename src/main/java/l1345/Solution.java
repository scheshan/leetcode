package l1345;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            final int ind = i;
            map.compute(arr[i], (k, v) -> {
                if (v == null) {
                    v = new LinkedList<>();
                }
                v.add(ind);
                return v;
            });
        }

        int[] visited = new int[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        addQueue(queue, visited, 0, 1);

        while (!queue.isEmpty()) {
            int i = queue.remove();
            addQueue(queue, visited, i - 1, visited[i] + 1);
            addQueue(queue, visited, i + 1, visited[i] + 1);

            List<Integer> list = map.get(arr[i]);
            if (list != null) {
                for (int j : list) {
                    addQueue(queue, visited, j, visited[i] + 1);
                }
            }
            map.remove(arr[i]);
        }

        return visited[visited.length - 1] - 1;
    }

    private void addQueue(Queue<Integer> queue, int[] visited, int i, int step) {
        if (i < 0 || i >= visited.length || visited[i] > 0) {
            return;
        }

        visited[i] = step;
        queue.add(i);
    }
}
