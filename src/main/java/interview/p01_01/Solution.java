package interview.p01_01;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public boolean isUnique(String astr) {
        int visit = 0;

        for (int i = 0; i < astr.length(); i++) {
            int n = 1 << (astr.charAt(i) - 'a');
            if ((visit & n) != 0) {
                return false;
            }
            visit |= n;
        }
        return true;
    }
}
