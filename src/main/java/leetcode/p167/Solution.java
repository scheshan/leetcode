package leetcode.p167;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return numbers;
    }
}
