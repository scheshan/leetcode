package l1374;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/29
 */
public class Solution {

    public String generateTheString(int n) {
        char[] arr = new char[n];

        if ((n & 1) == 1) {
            Arrays.fill(arr, 'a');
        } else {
            Arrays.fill(arr, 0, n - 1, 'a');
            arr[n - 1] = 'b';
        }
        return new String(arr);
    }
}
