package leetcode.p1238;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>(1 << n);
        list.add(0);

        int ind = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                int num = list.get(j) + (1 << (i - 1));
                list.add(num);
                if (num == start) {
                    ind = list.size() - 1;
                }
            }
        }

        if (ind == 0) {
            return list;
        }

        reverse(list, 0, ind - 1);
        reverse(list, ind, list.size() - 1);
        reverse(list, 0, list.size() - 1);
        return list;
    }

    private void reverse(List<Integer> list, int l, int r) {
        while (l < r) {
            int t = list.get(l);
            list.set(l, list.get(r));
            list.set(r, t);
            l++;
            r--;
        }
    }
}
