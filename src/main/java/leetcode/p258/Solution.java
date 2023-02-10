package leetcode.p258;

/**
 * Sioluton
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
