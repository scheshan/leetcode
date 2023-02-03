package leetcode.p210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new List[numCourses];
        int[] in = new int[numCourses];
        int[] res = new int[numCourses];
        int ind = numCourses - 1;

        for (int[] pre : prerequisites) {
            List<Integer> edge = edges[pre[0]];
            if (edge == null) {
                edge = new ArrayList<>();
                edges[pre[0]] = edge;
            }
            edge.add(pre[1]);
            in[pre[1]]++;
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty() && ind >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int n = queue.remove();
                res[ind--] = n;
                if (ind < 0) {
                    break;
                }

                List<Integer> edge = edges[n];
                if (edge != null) {
                    for (int next : edge) {
                        in[next]--;
                        if (in[next] == 0) {
                            queue.add(next);
                        }
                    }
                }
            }
        }

        if (ind >= 0) {
            return new int[0];
        }

        return res;
    }
}
