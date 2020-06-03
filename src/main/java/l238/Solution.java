package l238;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        int[] suffix = new int[nums.length + 1];

        prefix[0] = 1;
        suffix[suffix.length - 1] = 1;

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i + 1];
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().productExceptSelf(new int[]{1, 2, 3, 4});
    }
}
