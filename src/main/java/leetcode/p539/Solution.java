package leetcode.p539;

import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            arr[i] = transform(timePoints.get(i));
        }
        Arrays.sort(arr);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= arr.length; i++) {
            int cur = arr[0];
            if (i < arr.length) {
                cur = arr[i];
            }
            res = Math.min(res, cal(arr[i - 1], cur));
        }

        return res;
    }

    private int transform(String str) {
        int hours = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
        int minutes = (str.charAt(3) - '0') * 10 + (str.charAt(4) - '0');

        return hours * 60 + minutes;
    }

    private int cal(int x, int y) {
        if (x <= y) {
            return y - x;
        }
        return y + 1440 - x;
    }
}
