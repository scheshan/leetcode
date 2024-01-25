package leetcode.p168;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/25
 */
public class Solution {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            sb.append((char) ('A' + (columnNumber - 1) % 26));
            columnNumber = (columnNumber - 1) / 26;
        }

        return sb.reverse().toString();
    }
}
