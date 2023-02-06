package leetcode.p1523;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    public int countOdds(int low, int high) {
        return ((high + 1) >> 1) - (low >> 1);
    }
}
