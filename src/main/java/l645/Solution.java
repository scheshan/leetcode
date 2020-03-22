package l645;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for (int num : nums) {
            int ind = Math.abs(num) - 1;

            if (nums[ind] < 0) {
                res[0] = ind + 1;
            }
            nums[ind] *= -1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0 && res[0] != j + 1) {
                res[1] = j + 1;
                break;
            }
        }

        return res;
    }
}
