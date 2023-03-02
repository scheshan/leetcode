package leetcode.p1347;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        int res = s.length();

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (cnt[t.charAt(i) - 'a'] > 0) {
                res--;
                cnt[t.charAt(i) - 'a']--;
            }
        }
        return res;
    }
}
