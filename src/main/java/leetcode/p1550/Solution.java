package leetcode.p1550;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if ((arr[i - 2] & 1) == 1 && (arr[i - 1] & 1) == 1 && (arr[i] & 1) == 1) {
                return true;
            }
        }
        return false;
    }
}
