package l2351;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/1
 */
public class Solution {

    public char repeatedCharacter(String s) {
        boolean[] arr = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if (arr[ind]) {
                return s.charAt(i);
            }

            arr[ind] = true;
        }

        return ' ';
    }
}
