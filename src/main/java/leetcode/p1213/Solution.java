package leetcode.p1213;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i1 = 0, i2 = 0, i3 = 0;
        List<Integer> res = new ArrayList<>();

        while (i1 < arr1.length && i2 < arr2.length && i3 < arr3.length) {
            if (arr1[i1] == arr2[i2] && arr2[i2] == arr3[i3]) {
                res.add(arr1[i1]);
                i1++;
                i2++;
                i3++;
            } else if (arr1[i1] <= arr2[i2] && arr1[i1] <= arr3[i3]) {
                i1++;
            } else if (arr2[i2] <= arr1[i1] && arr2[i2] <= arr3[i3]) {
                i2++;
            } else {
                i3++;
            }
        }
        return res;
    }
}
