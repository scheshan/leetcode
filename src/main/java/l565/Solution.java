package l565;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/19
 */
public class Solution {

    public int arrayNesting(int[] nums) {
        int res = 0;

        int[] visit = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (visit[nums[i]] > 0) {
                continue;
            }

            deque.addLast(nums[i]);
            int start = nums[i];
            int j = nums[start];
            while (visit[j] == 0 && j != start) {
                deque.addLast(j);
                j = nums[j];
            }
            int c = 0;
            if (j != start) {
                c = visit[j];
            }
            while (!deque.isEmpty()) {
                visit[deque.removeLast()] = ++c;
            }
            res = Math.max(res, c);
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2});
    }
}
