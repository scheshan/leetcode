package l1347;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/5
 */
public class Solution {

    public int minSteps(String s, String t) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int res = 0;
        for (int i = 0; i < t.length(); i++) {
            if (count[t.charAt(i) - 'a'] == 0) {
                res++;
            } else {
                count[t.charAt(i) - 'a']--;
            }
        }
        return res;
    }
}
