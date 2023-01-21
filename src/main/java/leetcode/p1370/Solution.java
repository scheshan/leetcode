package leetcode.p1370;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public String sortString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        char[] res = new char[s.length()];
        int ind = 0;
        while (ind < res.length) {
            for (int i = 0; i < count.length && ind < res.length; i++) {
                if (count[i] > 0) {
                    count[i]--;
                    res[ind++] = (char) ('a' + i);
                }
            }
            for (int i = count.length - 1; i >= 0 && ind < res.length; i--) {
                if (count[i] > 0) {
                    count[i]--;
                    res[ind++] = (char) ('a' + i);
                }
            }
        }
        return new String(res);
    }
}
