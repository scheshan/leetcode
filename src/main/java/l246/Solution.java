package l246;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char l = num.charAt(left++);
            char r = num.charAt(right--);

            if (l == r && (l == '0' || l == '1' || l == '8')) {
                continue;
            }
            if (left - 1 < right + 1 && (l == '6' && r == '9' || l == '9' && r == '6')) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().isStrobogrammatic("69");
    }
}
