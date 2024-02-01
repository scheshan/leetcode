package leetcode.p210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }

        int[] in = new int[numCourses];
        for (int[] arr : prerequisites) {
            in[arr[0]]++;
            edges[arr[1]].add(arr[0]);
        }

        int[] res = new int[numCourses];
        int ind = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                res[ind++] = i;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            List<Integer> edge = edges[cur];
            for (Integer next : edge) {
                in[next]--;
                if (in[next] == 0) {
                    res[ind++] = next;
                    queue.add(next);
                }
            }
        }

        return ind == numCourses ? res : new int[]{};
    }
}
