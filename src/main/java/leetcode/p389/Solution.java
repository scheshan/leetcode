package leetcode.p389;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        int[] exist = new int[26];
        for (int i = 0; i < s.length(); i++) {
            exist[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (exist[t.charAt(i) - 'a'] == 0) {
                return t.charAt(i);
            }

            exist[t.charAt(i) - 'a']--;
        }

        return ' ';
    }
}
