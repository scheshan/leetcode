package l503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        Deque<Integer> deque = new LinkedList<>();

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    int k = deque.removeLast();
                    res[k] = nums[i];
                }
                deque.addLast(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().nextGreaterElements(new int[]{1, 2, 1});
    }
}
