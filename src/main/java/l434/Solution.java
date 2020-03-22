package l434;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int countSegments(String s) {
        boolean pre = false;

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                pre = true;
            } else {
                if (pre) {
                    res++;
                    pre = false;
                }
            }
        }

        return pre ? res + 1 : res;
    }
}
