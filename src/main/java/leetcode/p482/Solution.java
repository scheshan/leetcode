package leetcode.p482;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public String licenseKeyFormatting(String s, int k) {
        int nums = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                nums++;
            }
        }

        if (nums == 0) {
            return "";
        }

        int total = nums + nums / k - 1;
        if (nums % k != 0) {
            total++;
        }

        int first = nums % k;
        char[] arr = new char[total];
        int ind = 0;
        int si = 0;
        while (ind < total) {
            if (ind > 0) {
                arr[ind++] = '-';
            }

            int loopCount = k;
            if (ind == 0 && first > 0) {
                loopCount = first;
            }

            for (int i = 0; i < loopCount; i++) {
                while (si < s.length() && s.charAt(si) == '-') {
                    si++;
                }
                arr[ind++] = Character.toUpperCase(s.charAt(si++));
            }
        }
        return new String(arr);
    }
}
