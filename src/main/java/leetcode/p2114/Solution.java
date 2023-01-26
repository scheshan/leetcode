package leetcode.p2114;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int mostWordsFound(String[] sentences) {
        int res = 0;

        int cnt = 0;
        for (String str : sentences) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    cnt++;
                }
            }
            if (cnt + 1 > res) {
                res = cnt + 1;
            }
            cnt = 0;
        }
        return res;
    }
}
