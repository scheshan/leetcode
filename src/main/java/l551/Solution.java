package l551;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/28
 */
public class Solution {

    public boolean checkRecord(String s) {
        int a = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
            } else if (ch == 'L') {
                if (i < s.length() - 2 && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                    return false;
                }
            }
        }

        return true;
    }
}
