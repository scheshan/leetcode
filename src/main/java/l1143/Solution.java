package l1143;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int[] pre = new int[text2.length() + 1];
        int[] cur = new int[text2.length() + 1];

        int res = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                cur[j] = 0;
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = pre[j - 1] + 1;
                }
                cur[j] = Math.max(cur[j], pre[j]);
                cur[j] = Math.max(cur[j], cur[j - 1]);

                res = Math.max(res, cur[j]);
            }
            int[] t = pre;
            pre = cur;
            cur = t;
        }

        return res;
    }
}
