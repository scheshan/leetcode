package interview.p01_01;

public class Solution {
    public boolean isUnique(String astr) {
        boolean[] s = new boolean[26];

        for (char ch : astr.toCharArray()) {
            if (s[ch - 'a']) {
                return false;
            }
            s[ch - 'a'] = true;
        }

        return true;
    }
}
