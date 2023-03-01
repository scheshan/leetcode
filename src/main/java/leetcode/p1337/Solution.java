package leetcode.p1337;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] cnt = new int[mat.length];

        Queue<Integer> queue = new PriorityQueue<>(k + 1, (o1, o2) -> {
            int n = Integer.compare(cnt[o2], cnt[o1]);
            if (n != 0) {
                return n;
            }
            return Integer.compare(o2, o1);
        });

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                cnt[i] += mat[i][j];
            }

            queue.add(i);
            if (queue.size() > k) {
                queue.remove();
            }
        }


        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.remove();
        }
        return res;
    }
}
