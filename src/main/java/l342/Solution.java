package l342;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/9
 */
public class Solution {

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & num - 1) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
