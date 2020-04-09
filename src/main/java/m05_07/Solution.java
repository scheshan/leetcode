package m05_07;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/9
 */
public class Solution {

    public int exchangeBits(int num) {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }
}
