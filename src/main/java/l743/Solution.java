package l743;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/19
 */
public class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] edges = new List[N];
        for (int[] time : times) {
            List<int[]> list = edges[time[0] - 1];
            if (list == null) {
                list = new LinkedList<>();
                edges[time[0] - 1] = list;
            }
            list.add(time);
        }

        boolean[] visit = new boolean[N];
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.add(new int[]{K, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int[] item = queue.remove();
            if (visit[item[0] - 1]) {
                continue;
            }
            visit[item[0] - 1] = true;
            res = item[1];

            List<int[]> edge = edges[item[0] - 1];
            if (edge != null) {
                for (int[] e : edge) {
                    queue.add(new int[]{e[1], item[1] + e[2]});
                }
            }
        }

        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                return -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().networkDelayTime(new int[][]{
                new int[]{1, 2, 1},
                new int[]{2, 1, 3}
        }, 2, 2);
    }
}
