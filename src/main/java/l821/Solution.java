package l821;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/6
 */
public class Solution {

    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        Arrays.fill(res, Integer.MAX_VALUE);

        int left = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                while (left <= i) {
                    res[left] = i - left;
                    left++;
                }
            }
        }

        int right = S.length() - 1;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                while (right >= i) {
                    res[right] = Math.min(res[right], right - i);
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().shortestToChar("loveleetcode", 'e');
    }
}
