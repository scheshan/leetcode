package leetcode.p1460;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        for (int num : target) {
            count[num]++;
        }

        for (int num : arr) {
            if (count[num] <= 0) {
                return false;
            }
            count[num]--;
        }
        return true;
    }
}
