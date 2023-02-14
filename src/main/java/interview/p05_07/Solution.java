package interview.p05_07;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int exchangeBits(int num) {
        int n1 = 0b10101010101010101010101010101010;
        int n2 = 0b01010101010101010101010101010101;

        return ((num << 1) & n1) | ((num >> 1) & n2);
    }
}
