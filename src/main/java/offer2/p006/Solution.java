package offer2.p006;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int n = numbers[l] + numbers[r];
            if (n == target) {
                return new int[]{l, r};
            } else if (n < target) {
                l++;
            } else {
                r--;
            }
        }

        return null;
    }
}
