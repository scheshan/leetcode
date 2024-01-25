package leetcode.p171;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/25
 */
public class Solution {

    public int titleToNumber(String columnTitle) {
        int res = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A';

            res = res * 26 + num + 1;
        }

        return res;
    }
}
