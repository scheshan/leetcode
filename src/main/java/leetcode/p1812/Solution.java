package leetcode.p1812;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0) - 'A';
        if ((col & 1) == 0) {
            return (coordinates.charAt(1) - '1' & 1) == 1;
        } else {
            return (coordinates.charAt(1) - '1' & 1) == 0;
        }
    }
}
