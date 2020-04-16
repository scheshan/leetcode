package l859;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/16
 */
public class Solution {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        boolean hasSameCharacter = false;

        char[] left = new char[2];
        char[] right = new char[2];
        int ind = 0;
        int[] count = new int[26];

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) {
                count[A.charAt(i) - 'a']++;
                if (count[A.charAt(i) - 'a'] > 1) {
                    hasSameCharacter = true;
                }
            } else {
                if (ind >= 2) {
                    return false;
                }

                left[ind] = A.charAt(i);
                right[ind] = B.charAt(i);
                ind++;
            }
        }

        if (ind == 0) {
            return hasSameCharacter;
        } else if (ind == 1) {
            return false;
        } else {
            return left[1] == right[0] && left[0] == right[1];
        }
    }
}
