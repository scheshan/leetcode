package m17_19;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int[] missingTwo(int[] nums) {
        int[] extra = new int[]{1, 1};

        for (int num : nums) {
            int ind = Math.abs(num) - 1;
            if (ind < nums.length) {
                nums[ind] *= -1;
            } else {
                extra[ind - nums.length] = -1;
            }
        }

        int[] res = new int[2];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[j++] = i + 1;
            }
        }
        for (int i = 0; i < extra.length; i++) {
            if (extra[i] > 0) {
                res[j++] = nums.length + i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution().missingTwo(new int[]{1});
        System.out.println(Arrays.toString(res));
    }
}
