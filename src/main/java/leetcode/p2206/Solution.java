package leetcode.p2206;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public boolean divideArray(int[] nums) {
        boolean[] set = new boolean[501];
        int single = 0;

        for (int num : nums) {
            if (set[num]) {
                single--;
            } else {
                single++;
            }
            set[num] = !set[num];
        }
        return single == 0;
    }
}
