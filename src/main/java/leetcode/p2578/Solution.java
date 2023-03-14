package leetcode.p2578;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/14
 */
public class Solution {

    public int splitNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);

        int n1 = 0, n2 = 0;
        for (int i = 0; i < arr.length; i += 2) {
            n1 = n1 * 10 + arr[i] - '0';
            if (i + 1 < arr.length) {
                n2 = n2 * 10 + arr[i + 1] - '0';
            }
        }

        return n1 + n2;
    }
}
