package leetcode.p496;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] map = new int[10001];

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!deque.isEmpty() && nums2[deque.peekLast()] < num) {
                deque.removeLast();
            }

            if (!deque.isEmpty()) {
                map[num] = nums2[deque.peekLast()];
            } else {
                map[num] = -1;
            }
            deque.addLast(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map[nums1[i]];
        }
        return nums1;
    }
}
