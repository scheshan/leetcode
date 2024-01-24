package leetcode.p210;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int ind = 0;

        int[] in = new int[numCourses];
        List<Integer>[] edge = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edge[i] = new LinkedList<>();
        }

        for (int[] pre : prerequisites) {
            in[pre[0]]++;
            edge[pre[1]].add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.remove();
            res[ind++] = i;

            for (Integer next : edge[i]) {
                in[next]--;
                if (in[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return ind == numCourses ? res : new int[0];
    }
}
