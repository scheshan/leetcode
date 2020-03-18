package l925;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public boolean isLongPressedName(String name, String typed) {
        int left = 0;
        int right = 0;

        while (left < name.length() && right < typed.length()) {
            char l = name.charAt(left);
            char r = typed.charAt(right);

            if (l == r) {
                left++;
                right++;
            } else {
                if (right > 0 && r == typed.charAt(right - 1)) {
                    if (left > 0 && l != name.charAt(left - 1)) {
                        right++;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        while (right < typed.length()) {
            if (right > 0 && typed.charAt(right) == typed.charAt(right - 1)) {
                right++;
            } else {
                return false;
            }
        }

        return left == name.length();
    }

    public static void main(String[] args) {
        new Solution().isLongPressedName("zdkrwmxim", "zddkrrwmxxiimm");
    }
}
