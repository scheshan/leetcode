package l848;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/15
 */
public class Solution {

    public String shiftingLetters(String S, int[] shifts) {
        int count = 0;

        char[] arr = S.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--) {
            count = (count + shifts[i]) % 26;

            arr[i] = (char) ('a' + (arr[i] - 'a' + count) % 26);
        }

        return new String(arr);
    }
}
