package l786;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/2
 */
public class Solution {

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare(A[o1[0]] * 1.0 / A[o1[1]], A[o2[0]] * 1.0 / A[o2[1]]);
            }
        });

        for (int i = 1; i < A.length; i++) {
            queue.add(new int[]{0, i});
        }

        for (int i = 0; i < K - 1; i++) {
            int[] item = queue.remove();
            if (A[item[0] + 1] < A[item[1]]) {
                item[0]++;
                queue.add(item);
            }
        }
        return new int[]{A[queue.peek()[0]], A[queue.peek()[1]]};
    }

    public static void main(String[] args) {
        new Solution().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    }
}
