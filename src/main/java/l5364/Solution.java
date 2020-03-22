package l5364;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int ind = index[i];

            for (int j = i - 1; j >= ind; j--) {
                res[j + 1] = res[j];
            }
            res[ind] = num;
        }

        return res;
    }
}
