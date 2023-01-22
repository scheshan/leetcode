package leetcode.p2315;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int countAsterisks(String s) {
        int res = 0;
        boolean in = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!in) {
                    res++;
                }
            } else if (s.charAt(i) == '|') {
                in = !in;
            }
        }
        return res;
    }
}
