package leetcode.p303;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class NumArray {

    private int[] total;

    public NumArray(int[] nums) {
        this.total = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            this.total[i + 1] = this.total[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return total[right + 1] - total[left];
    }
}
