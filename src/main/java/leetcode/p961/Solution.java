package leetcode.p961;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int repeatedNTimes(int[] nums) {
        int n1 = nums[0];
        int c1 = 1;

        int vote = 0;
        int n2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == n1) {
                c1++;
            }

            if (vote == 0) {
                vote++;
                n2 = nums[i];
            } else if (nums[i] == n2) {
                vote++;
            } else {
                vote--;
            }
        }

        if (c1 >= (nums.length >> 1)) {
            return n1;
        }
        return n2;
    }
}
