package leetcode.p1374;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public String generateTheString(int n) {
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            res[i] = 'a';
        }
        if ((n & 1) == 0) {
            res[0] = 'b';
        }
        return new String(res);
    }
}
