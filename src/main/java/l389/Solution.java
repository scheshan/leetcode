package l389;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        char[] c1 = new char[26];
        char[] c2 = new char[26];

        for (int i = 0; i < s.length(); i++) {
            c1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            c2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return (char) ('a' + i);
            }
        }

        return ' ';
    }
}
