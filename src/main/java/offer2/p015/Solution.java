package offer2.p015;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        boolean[] exist = new boolean[26];
        int[] count = new int[26];
        int total = 0;
        for (int i = 0; i < p.length(); i++) {
            if (!exist[p.charAt(i) - 'a']) {
                total++;
                exist[p.charAt(i) - 'a'] = true;
            }
            count[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;
        int cur = 0;
        while (r < s.length()) {
            int ind1 = s.charAt(r) - 'a';
            if (exist[ind1]) {
                count[ind1]--;
                if (count[ind1] == 0) {
                    cur++;
                }
            }
            r++;

            if (r - l >= p.length()) {
                if (cur == total) {
                    res.add(l);
                }

                int ind2 = s.charAt(l++) - 'a';
                if (exist[ind2]) {
                    count[ind2]++;
                    if (count[ind2] == 1) {
                        cur--;
                    }
                }
            }
        }
        return res;
    }
}
