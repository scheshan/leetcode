package leetcode.p2769;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int theMaximumAchievableX(int num, int t) {
        return num + (t << 1);
    }
}
