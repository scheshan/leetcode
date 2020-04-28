package l1150;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/29
 */
public class Solution {

    public boolean isMajorityElement(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int ind = left;
        if (ind >= nums.length) {
            ind--;
        } else if (nums[ind] != target) {
            ind++;
        }
        return ind < nums.length / 2 && nums[ind + nums.length / 2] == target;
    }

    public static void main(String[] args) {
        boolean res = new Solution().isMajorityElement(new int[]{2}, 2);
        System.out.println(res);
    }
}
