package leetcode.p2103;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int countPoints(String rings) {
        byte[] arr = new byte[10];

        for (int i = 0; i < rings.length(); i += 2) {
            char ch = rings.charAt(i);
            int ind = rings.charAt(i + 1) - '0';

            if (ch == 'B') {
                arr[ind] |= 1;
            } else if (ch == 'G') {
                arr[ind] |= 2;
            } else {
                arr[ind] |= 4;
            }
        }

        int res = 0;
        for (byte num : arr) {
            if (num == 7) {
                res++;
            }
        }
        return res;
    }
}
