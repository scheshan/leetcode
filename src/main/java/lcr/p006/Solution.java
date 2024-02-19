package lcr.p006;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/19
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l, r};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return null;
    }
}
