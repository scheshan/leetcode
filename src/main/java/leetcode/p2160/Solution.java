package leetcode.p2160;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int minimumSum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);

        return (arr[0] - '0') * 10 + arr[3] - '0' + (arr[1] - '0') * 10 + arr[2] - '0';
    }
}
