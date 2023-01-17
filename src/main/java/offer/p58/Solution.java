package offer.p58;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public String reverseLeftWords(String s, int n) {
        n = n % s.length();

        StringBuilder res = new StringBuilder(s.length());
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }

        return res.toString();
    }
}
