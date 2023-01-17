package leetcode.p2413;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int smallestEvenMultiple(int n) {
        if ((n & 1) == 0) {
            return n;
        }
        return n << 1;
    }
}
