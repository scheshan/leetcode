package leetcode.p2268;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int minimumKeypresses(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        Arrays.sort(cnt);

        int res = 0;
        for (int i = 0; i < 26; i++) {
            int ind = 26 - i - 1;
            if (i < 9) {
                res += cnt[ind];
            } else if (i < 18) {
                res += cnt[ind] << 1;
            } else {
                res += cnt[ind] * 3;
            }
        }
        return res;
    }
}
