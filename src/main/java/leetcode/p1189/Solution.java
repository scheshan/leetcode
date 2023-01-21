package leetcode.p1189;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }

        int res = count['a' - 'a'];
        res = Math.min(res, count['b' - 'a']);
        res = Math.min(res, count['l' - 'a'] >> 1);
        res = Math.min(res, count['o' - 'a'] >> 1);
        res = Math.min(res, count['n' - 'a']);

        return res;
    }
}
