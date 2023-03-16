package leetcode.p1136;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/16
 */
public class Solution {

    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] edges = new List[n + 1];
        int[] in = new int[n + 1];
        for (int[] pair : relations) {
            addEdge(edges, pair[0], pair[1]);
            in[pair[1]]++;
        }

        boolean[] visit = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.remove();
                if (edges[num] != null) {
                    for (int next : edges[num]) {
                        in[next]--;
                        if (in[next] == 0) {
                            queue.add(next);
                        }
                    }
                }
                n--;
            }
        }

        return n > 0 ? -1 : res;
    }

    private void addEdge(List<Integer>[] edges, int i, int j) {
        List<Integer> list = edges[i];
        if (list == null) {
            list = new ArrayList<>();
            edges[i] = list;
        }
        list.add(j);
    }
}
