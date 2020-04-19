package l680;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public boolean validPalindrome(String s) {
        if (s.length() <= 2) {
            return true;
        }

        return valid(s, false);
    }

    private boolean valid(String s, boolean replaced) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (replaced) {
                    return false;
                }

                return valid(s.substring(left, right), true)
                        || valid(s.substring(left + 1, right + 1), true);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution().validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu");
        System.out.println(res);
    }
}
