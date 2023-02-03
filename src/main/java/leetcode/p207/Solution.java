package leetcode.p207;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<Integer>[] edges = new List[numCourses];
        for (int[] pre : prerequisites) {
            in[pre[1]]++;
            if (edges[pre[0]] == null) {
                edges[pre[0]] = new ArrayList<>();
            }
            edges[pre[0]].add(pre[1]);
        }

        int total = numCourses;
        Queue<Integer> queue = new ArrayDeque<>(numCourses);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                addQueue(queue, i, in);
                total--;
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.remove();
            List<Integer> edge = edges[num];
            if (edge != null) {
                for (int next : edge) {
                    if (addQueue(queue, next, in)) {
                        total--;
                    }
                }
            }
        }

        return total == 0;
    }

    private boolean addQueue(Queue<Integer> queue, int num, int[] visit) {
        if (visit[num] < 0) {
            return false;
        }
        visit[num]--;
        if (visit[num] > 0) {
            return false;
        }

        visit[num] = -1;
        queue.add(num);
        return true;
    }
}
