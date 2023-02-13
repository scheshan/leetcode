package leetcode.p1234;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public int balancedString(String s) {
        int[] cnt = new int[4];
        for (int i = 0; i < s.length(); i++) {
            cnt[ind(s.charAt(i))]++;
        }
        for (int i = 0; i < 4; i++) {
            cnt[i] -= Math.max(0, s.length() >> 2);
        }

        int[] cur = new int[4];

        if (valid(cnt, cur)) {
            return 0;
        }

        int l = 0;
        int r = 0;
        int res = s.length();
        while (r < s.length()) {
            int ind = ind(s.charAt(r));
            if (cnt[ind] > 0) {
                cur[ind]++;
            }
            r++;

            while (l < r && valid(cnt, cur)) {
                res = Math.min(res, r - l);

                ind = ind(s.charAt(l++));
                if (cnt[ind] > 0) {
                    cur[ind]--;
                }
            }
        }
        return res;
    }

    private int ind(char ch) {
        switch (ch) {
            case 'Q':
                return 0;
            case 'W':
                return 1;
            case 'E':
                return 2;
            default:
                return 3;
        }
    }

    private boolean valid(int[] cnt, int[] cur) {
        for (int i = 0; i < cnt.length; i++) {
            if (cur[i] < cnt[i]) {
                return false;
            }
        }
        return true;
    }
}
