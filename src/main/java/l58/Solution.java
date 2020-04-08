package l58;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/8
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int right = -1;
        int left = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (right > 0) {
                    left = i + 1;
                    break;
                }
            } else {
                if (right == -1) {
                    right = i;
                }
            }
        }

        if (left < 0 && right < 0) {
            return 0;
        }

        if (left < 0) {
            left = 0;
        }

        return right - left + 1;
    }
}
