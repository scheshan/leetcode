package leetcode.p1748;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        int res = 0;

        for (int num : nums) {
            if (arr[num] == 0) {
                res += num;
            } else if (arr[num] == 1) {
                res -= num;
            }
            arr[num]++;
        }
        return res;
    }
}
