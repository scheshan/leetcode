package l207;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int[] degrees = new int[numCourses];

        for (int[] pre : prerequisites) {
            edges.compute(pre[0], (k, v) -> {
                if (v == null) {
                    v = new LinkedList<>();
                }
                v.add(pre[1]);
                return v;
            });
            degrees[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.remove();
            List<Integer> edge = edges.get(course);
            if (edge == null) {
                continue;
            }
            for (int e : edge) {
                degrees[e]--;
                if (degrees[e] == 0) {
                    queue.add(e);
                }
            }
        }

        for (int d : degrees) {
            if (d > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().canFinish(2, new int[][]{new int[]{1, 0}});
    }
}
