package leetcode.p2083;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public long numberOfSubstrings(String s) {
        long[] cnt = new long[26];
        long res = 0;

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            res += cnt[s.charAt(i) - 'a'];
        }
        return res;
    }
}
