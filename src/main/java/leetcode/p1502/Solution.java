package leetcode.p1502;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int delta = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != delta) {
                return false;
            }
        }
        return true;
    }
}
