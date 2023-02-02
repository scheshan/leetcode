package leetcode.p2073;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = k + 1;

        int min = Integer.MAX_VALUE;
        Queue<Integer> queue = new ArrayDeque<>(k);
        for (int i = k + 1; i < tickets.length; i++) {
            min = Math.min(min, tickets[i]);
            queue.add(i);
        }
        for (int i = 0; i <= k; i++) {
            tickets[i]--;
            if (tickets[i] > 0) {
                min = Math.min(min, tickets[i]);
                queue.add(i);
            }
        }

        while (tickets[k] > 0) {
            int size = queue.size();
            int n = min;
            min = Integer.MAX_VALUE;
            res += n * size;
            for (int i = 0; i < size; i++) {
                int ind = queue.remove();
                tickets[ind] -= n;
                if (tickets[ind] > 0) {
                    min = Math.min(min, tickets[ind]);
                    queue.add(ind);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0);
    }
}
