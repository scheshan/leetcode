package m08_03;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int n = nums[i];

            if (n == i) {
                return i;
            }

            if (n < i) {
                i++;
            } else {
                i = n;
            }
        }
        return -1;
    }
}
