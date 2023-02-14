package leetcode.p744;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];

        int l = 0;
        int r = letters.length;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (letters[mid] > target) {
                res = letters[mid];
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
