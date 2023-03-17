package leetcode.p1338;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/17
 */
public class Solution {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int[] nums = new int[count.size()];
        int ind = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            nums[ind++] = entry.getValue();
        }
        Arrays.sort(nums);

        int res = 0;
        int deleted = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            deleted += nums[i];
            res++;

            if (deleted * 2 >= arr.length) {
                break;
            }
        }
        return res;
    }
}
