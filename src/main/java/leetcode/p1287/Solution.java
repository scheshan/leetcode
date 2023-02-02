package leetcode.p1287;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int findSpecialInteger(int[] arr) {
        int pre = Integer.MIN_VALUE;
        int cnt = 0;
        for (int num : arr) {
            if (pre == num) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt * 4 > arr.length) {
                return num;
            }
            pre = num;
        }
        return -1;
    }
}
