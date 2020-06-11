package l1470;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/11
 */
public class Solution {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];

        int i = 0;
        int j = nums.length / 2;

        int ind = 0;
        for (int k = 0; k < nums.length / 2; k++) {
            res[ind++] = nums[i++];
            res[ind++] = nums[j++];
        }
        return res;
    }
}
