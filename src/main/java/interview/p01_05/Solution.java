package interview.p01_05;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String s1 = first;
        String s2 = second;
        if (second.length() < first.length()) {
            s1 = second;
            s2 = first;
        }

        int ind = 0;
        while (ind < s1.length() && s1.charAt(ind) == s2.charAt(ind)) {
            ind++;
        }

        return valid(s1, s2, ind, ind + 1) || valid(s1, s2, ind + 1, ind + 1);
    }

    private boolean valid(String s1, String s2, int i1, int i2) {
        while (i1 < s1.length() && i2 < s2.length()) {
            if (s1.charAt(i1) != s2.charAt(i2)) {
                return false;
            }
            i1++;
            i2++;
        }
        return i1 >= s1.length() && i2 >= s2.length();
    }
}
