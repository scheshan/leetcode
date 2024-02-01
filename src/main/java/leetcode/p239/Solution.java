package leetcode.p239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int ind = 0;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            addDeque(deque, nums, ind + i);
        }

        while (ind < res.length) {
            res[ind] = nums[deque.peekFirst()];
            if (deque.peekFirst() <= ind) {
                deque.removeFirst();
            }
            if (ind + k < nums.length) {
                addDeque(deque, nums, ind + k);
            }
            ind++;
        }

        return res;
    }

    private void addDeque(Deque<Integer> deque, int[] nums, int i) {
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.removeLast();
        }
        deque.addLast(i);
    }
}
