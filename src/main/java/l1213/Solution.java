package l1213;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0;
        int j = 0;
        int k = 0;

        List<Integer> res = new LinkedList<>();

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            int n1 = arr1[i], n2 = arr2[j], n3 = arr3[k];

            if (n1 == n2 && n2 == n3) {
                res.add(n1);
            }

            int min = Math.min(n1, Math.min(n2, n3));
            if (n1 == min) {
                i++;
            }
            if (n2 == min) {
                j++;
            }
            if (n3 == min) {
                k++;
            }
        }
        return res;
    }
}
