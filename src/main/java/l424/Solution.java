package l424;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/9
 */
public class Solution {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int max = 0;
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            count[ch - 'A']++;
            max = Math.max(max, count[ch - 'A']);

            if (right - left + 1 - max <= k) {
                res = Math.max(res, right - left + 1);
            } else {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().characterReplacement("AABABBA", 1);
        System.out.println(res);
    }
}
