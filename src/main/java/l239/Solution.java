package l239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        for (int j = 0; j < k; j++) {
            add(deque, nums, j);
        }

        for (int i = 0; i < res.length; i++) {
            int j = i + k;
            res[i] = nums[deque.peekFirst()];
            if (deque.peekFirst() == j - k) {
                deque.removeFirst();
            }
            add(deque, nums, j);
        }

        return res;
    }

    private void add(Deque<Integer> deque, int[] nums, int i) {
        if (i < nums.length) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        int[] res = new Solution().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        System.out.println(Arrays.toString(res));
    }
}
