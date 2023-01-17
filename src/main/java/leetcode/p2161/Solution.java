package leetcode.p2161;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public int[] pivotArray(int[] nums, int pivot) {
        int a = 0, b = 0;
        for (int num : nums) {
            if (num < pivot) {
                a++;
            } else if (num == pivot) {
                b++;
            }
        }

        int[] res = new int[nums.length];
        int l = 0;
        int m = a;
        int r = a + b;
        for (int num : nums) {
            if (num < pivot) {
                res[l++] = num;
            } else if (num == pivot) {
                res[m++] = num;
            } else {
                res[r++] = num;
            }
        }

        return res;
    }
}
