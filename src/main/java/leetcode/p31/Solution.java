package leetcode.p31;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>(nums.length);

        for (int i = nums.length - 1; i >= 0; i--) {
            if (deque.isEmpty() || nums[deque.peekLast()] <= nums[i]) {
                deque.addLast(i);
                continue;
            }

            int pre = deque.removeLast();
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
                pre = deque.removeLast();
            }

            swap(nums, i, pre);
            reverse(nums, i + 1, nums.length - 1);
            return;
        }

        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int d = nums[i];
        nums[i] = nums[j];
        nums[j] = d;
    }
}
