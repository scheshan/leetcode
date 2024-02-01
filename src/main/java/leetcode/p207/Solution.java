package leetcode.p207;

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }

        int[] in = new int[numCourses];
        for (int[] arr : prerequisites) {
            in[arr[1]]++;
            edges[arr[0]].add(arr[1]);
        }

        int total = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                total++;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            List<Integer> edge = edges[cur];
            for (Integer next : edge) {
                in[next]--;
                if (in[next] == 0) {
                    total++;
                    queue.add(next);
                }
            }
        }

        return total == numCourses;
    }
}
