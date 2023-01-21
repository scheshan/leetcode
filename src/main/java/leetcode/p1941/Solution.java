package leetcode.p1941;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            cnt = Math.max(cnt, count[s.charAt(i) - 'a']);
        }

        for (int c : count) {
            if (c > 0 && c != cnt) {
                return false;
            }
        }
        return true;
    }
}
