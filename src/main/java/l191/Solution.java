package l191;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }

        return result;
    }
}
