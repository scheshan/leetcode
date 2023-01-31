package leetcode.p2094;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int num : digits) {
            count[num]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 100; i <= 998; i += 2) {
            if (valid(i, count)) {
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private boolean valid(int num, int[] count) {
        int x = num % 10;
        num /= 10;
        int y = num % 10;
        num /= 10;
        int z = num % 10;

        count[x]--;
        count[y]--;
        count[z]--;

        boolean res = false;
        if (count[x] >= 0 && count[y] >= 0 && count[z] >= 0) {
            res = true;
        }

        count[x]++;
        count[y]++;
        count[z]++;
        return res;
    }
}
