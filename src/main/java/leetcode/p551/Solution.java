package leetcode.p551;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                l++;
                if (l >= 3) {
                    return false;
                }
            } else {
                l = 0;
                if (s.charAt(i) == 'A') {
                    a++;
                }
            }
        }
        return a < 2;
    }
}
