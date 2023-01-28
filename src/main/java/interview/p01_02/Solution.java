package interview.p01_02;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int ind = s2.charAt(i) - 'a';
            if (count[ind] == 0) {
                return false;
            }
            count[ind]--;
        }
        return true;
    }
}
