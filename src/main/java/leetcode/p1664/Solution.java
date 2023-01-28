package leetcode.p1664;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int waysToMakeFair(int[] nums) {
        int oddLeft = 0;
        int evenLeft = 0;
        int oddRight = 0;
        int evenRight = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1) {
                oddRight += nums[i];
            } else {
                evenRight += nums[i];
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1) {
                oddRight -= nums[i];
            } else {
                evenRight -= nums[i];
            }
            if (oddLeft + evenRight == evenLeft + oddRight) {
                res++;
            }
            if ((i & 1) == 1) {
                oddLeft += nums[i];
            } else {
                evenLeft += nums[i];
            }
        }
        return res;
    }
}
