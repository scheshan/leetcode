package m17_10;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/31
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                major = num;
                count++;
            } else {
                if (major == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        if (count > 0) {
            int valid = 0;
            for (int num : nums) {
                if (num == major) {
                    valid++;
                }
            }

            return valid > nums.length / 2 ? major : -1;
        } else {
            return -1;
        }
    }
}
