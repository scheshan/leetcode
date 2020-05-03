package l5402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/3
 */
public class Solution {

    public int longestSubarray(int[] nums, int limit) {
        int res = 1;
        int delta = 0;
        int left = 0;
        int right = 0;

        Deque<Integer> minStack = new LinkedList<>();
        Deque<Integer> maxStack = new LinkedList<>();

        while (right < nums.length) {
            while (!minStack.isEmpty() && nums[minStack.peekLast()] > nums[right]) {
                minStack.removeLast();
            }
            minStack.addLast(right);
            while (!maxStack.isEmpty() && nums[maxStack.peekLast()] < nums[right]) {
                maxStack.removeLast();
            }
            maxStack.addLast(right);

            int min = nums[minStack.peekFirst()];
            int max = nums[maxStack.peekFirst()];
            if (max - min <= limit) {
                res = Math.max(res, right - left + 1);
            }

            right++;

            while (max - min > limit) {
                if (!minStack.isEmpty() && minStack.peekFirst() == left) {
                    minStack.removeFirst();
                }
                if (!maxStack.isEmpty() && maxStack.peekFirst() == left) {
                    maxStack.removeFirst();
                }
                min = nums[minStack.peekFirst()];
                max = nums[maxStack.peekFirst()];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0);
        System.out.println(res);
    }
}
