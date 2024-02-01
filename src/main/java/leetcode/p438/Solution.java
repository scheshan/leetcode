package leetcode.p438;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        boolean[] exist = new boolean[26];
        int[] cnt = new int[26];
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            int ind = p.charAt(i) - 'a';
            if (!exist[ind]) {
                exist[ind] = true;
                count++;
            }
            cnt[ind]++;
        }

        int l = 0, r = 0;
        while (r < s.length()) {
            int ind = s.charAt(r++) - 'a';

            if (exist[ind]) {
                cnt[ind]--;
                if (cnt[ind] == 0) {
                    count--;
                }
            }

            if (r - l > p.length()) {
                ind = s.charAt(l++) - 'a';
                if (exist[ind]) {
                    cnt[ind]++;
                    if (cnt[ind] == 1) {
                        count++;
                    }
                }
            }

            if (r - l == p.length() && count == 0) {
                res.add(l);
            }
        }

        return res;
    }
}
