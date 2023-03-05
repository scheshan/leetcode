package leetcode.p847;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/5
 */
public class Solution {

    public int shortestPathLength(int[][] graph) {
        int end = 0;
        Set<Integer>[] visit = new Set[graph.length];
        for (int i = 0; i < graph.length; i++) {
            end |= 1 << i;
            visit[i] = new HashSet<>();
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            queue.add(new int[]{i, 1 << i, 0, i});
            visit[i].add(1 << i);
        }

        while (!queue.isEmpty()) {
            int[] arr = queue.remove();
            if (arr[1] == end) {
                return arr[2];
            }

            int[] edge = graph[arr[0]];
            for (int next : edge) {
                int flag = arr[1] | (1 << next);
                if (visit[next].contains(flag)) {
                    continue;
                }
                visit[next].add(flag);

                int[] a = new int[]{next, flag, arr[2] + 1, arr[3]};
                queue.add(a);
            }
        }

        return -1;
    }
}
