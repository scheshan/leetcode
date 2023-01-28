package offer2.p014;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        boolean[] exist = new boolean[26];
        int[] count = new int[26];
        int total = 0;
        for (int i = 0; i < s1.length(); i++) {
            int ind = s1.charAt(i) - 'a';
            if (!exist[ind]) {
                total++;
                exist[ind] = true;
            }
            count[ind]++;
        }

        int l = 0;
        int r = 0;
        int cur = 0;
        while (r < s2.length()) {
            int ind = s2.charAt(r++) - 'a';
            if (exist[ind]) {
                count[ind]--;
                if (count[ind] == 0) {
                    cur++;
                }
            }
            if (r - l > s1.length()) {
                ind = s2.charAt(l++) - 'a';
                if (exist[ind]) {
                    count[ind]++;
                }
                if (count[ind] == 1) {
                    cur--;
                }
            }
            if (cur == total) {
                return true;
            }
        }
        return false;
    }
}
