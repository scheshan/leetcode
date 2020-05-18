package l665;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/18
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {
        boolean replaced = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }

            if (replaced) {
                return false;
            }
            int c = 0;
            int j = i - 1;
            for (; j >= 0 && nums[j] > nums[i]; j--) {
                c++;
            }

            if (c > 1) {
                nums[i] = nums[i - 1];
            } else {
                nums[j + 1] = nums[i];
            }

            replaced = true;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution().checkPossibility(new int[]{4, 2, 3});
        System.out.println(res);
    }
}
