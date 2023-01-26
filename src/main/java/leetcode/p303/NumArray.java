package leetcode.p303;

/**
 * NumArray
 *
 * @author heshan
 * @date 2023/1/26
 */
public class NumArray {

    private int[] pre;

    public NumArray(int[] nums) {
        pre = nums;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                pre[i] += pre[i - 1];
            }
        }
    }

    public int sumRange(int left, int right) {
        int p = 0;
        if (left > 0) {
            p = pre[left - 1];
        }
        return pre[right] - p;
    }
}
