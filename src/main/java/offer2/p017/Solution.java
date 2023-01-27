package offer2.p017;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public String minWindow(String s, String t) {
        String res = "";
        if (s.length() < t.length()) {
            return res;
        }

        boolean[] map = new boolean[52];
        int[] count = new int[52];
        int total = 0;
        for (int i = 0; i < t.length(); i++) {
            if (!map[ind(t.charAt(i))]) {
                total++;
            }
            map[ind(t.charAt(i))] = true;
            count[ind(t.charAt(i))]++;
        }

        int l = 0;
        int r = 0;
        int cur = 0;
        while (r < s.length()) {
            int ind = ind(s.charAt(r));
            if (map[ind]) {
                count[ind]--;
                if (count[ind] == 0) {
                    cur++;
                }
            }
            r++;

            while (cur == total) {
                if (res.length() == 0 || r - l < res.length()) {
                    res = s.substring(l, r);
                }
                int ind2 = ind(s.charAt(l++));
                if (map[ind2]) {
                    count[ind2]++;
                    if (count[ind2] == 1) {
                        cur--;
                    }
                }
            }
        }
        return res;
    }

    private int ind(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        }
        return 26 + ch - 'A';
    }
}
