package l378;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/2
 */
public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(matrix[o1[0]][o1[1]], matrix[o2[0]][o2[1]]);
            }
        });

        for (int i = 0; i < matrix[0].length; i++) {
            queue.add(new int[]{0, i});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] item = queue.remove();

            if (item[0] < matrix.length - 1) {
                queue.add(new int[]{item[0] + 1, item[1]});
            }
        }

        return matrix[queue.peek()[0]][queue.peek()[1]];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 3, 5};
        matrix[1] = new int[]{6, 7, 12};
        matrix[2] = new int[]{11, 14, 14};

        new Solution().kthSmallest(matrix, 6);
    }
}
