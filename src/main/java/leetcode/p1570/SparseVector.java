package leetcode.p1570;

/**
 * SparseVector
 *
 * @author heshan
 * @date 2024/2/17
 */
public class SparseVector {

    private int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res += nums[i] * vec.nums[i];
        }

        return res;
    }
}
