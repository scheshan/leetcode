package leetcode.p1356;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        list.sort((n1, n2) -> {
            int b1 = countBit(n1);
            int b2 = countBit(n2);
            if (b1 == b2) {
                return n1 - n2;
            }
            return b1 - b2;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int countBit(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
