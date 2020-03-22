package l210;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        int[] degrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        for (int[] pre : prerequisites) {
            degrees[pre[0]]++;
            edges.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.remove();

            res[index++] = course;

            List<Integer> edge = edges.get(course);
            for (int e : edge) {
                degrees[e]--;
                if (degrees[e] == 0) {
                    queue.add(e);
                }
            }
        }

        if (index == numCourses) {
            return res;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        new Solution().findOrder(2, new int[][]{new int[]{1, 0}});
    }
}
