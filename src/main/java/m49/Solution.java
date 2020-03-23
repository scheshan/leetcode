package m49;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = nums[p2] * 2;
            int n3 = nums[p3] * 3;
            int n5 = nums[p5] * 5;

            nums[i] = Math.min(n2, Math.min(n3, n5));
            if (n2 == nums[i]) {
                p2++;
            }
            if (n3 == nums[i]) {
                p3++;
            }
            if (n5 == nums[i]) {
                p5++;
            }
        }

        return nums[nums.length - 1];
    }
}
