package leetcode.p1129;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        List<Integer>[][] edges = new List[n][2];
        for (int[] edge : redEdges) {
            if (edges[edge[0]][0] == null) {
                edges[edge[0]][0] = new ArrayList<>();
            }
            edges[edge[0]][0].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            if (edges[edge[0]][1] == null) {
                edges[edge[0]][1] = new ArrayList<>();
            }
            edges[edge[0]][1].add(edge[1]);
        }

        bfs(res, edges);
        return res;
    }

    private void bfs(int[] res, List<Integer>[][] edges) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[res.length][2];
        addQueue(queue, visit, new int[]{0, 0});
        addQueue(queue, visit, new int[]{0, 1});
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.remove();
                if (res[point[0]] < 0) {
                    res[point[0]] = length;
                } else {
                    res[point[0]] = Math.min(res[point[0]], length);
                }

                List<Integer> list = edges[point[0]][1 - point[1]];
                if (list != null) {
                    for (int next : list) {
                        addQueue(queue, visit, new int[]{next, 1 - point[1]});
                    }
                }
            }
            length++;
        }
    }

    private void addQueue(Queue<int[]> queue, boolean[][] visit, int[] point) {
        if (visit[point[0]][point[1]]) {
            return;
        }
        visit[point[0]][point[1]] = true;
        queue.add(point);
    }
}
