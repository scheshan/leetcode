package l169;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/13
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else {
                if (nums[i] != major) {
                    count--;
                } else {
                    count++;
                }
            }
        }

        return major;
    }
}
