package m21;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];

        int left = 0;
        int right = res.length - 1;

        for (int n : nums) {
            if ((n & 1) == 1) {
                res[left++] = n;
            } else {
                res[right--] = n;
            }
        }

        return res;
    }
}
