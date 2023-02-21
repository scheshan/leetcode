package leetcode.p989;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/21
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>(num.length + 1);
        boolean promotion = false;
        int ind = num.length - 1;
        while (ind >= 0 || k > 0 || promotion) {
            int n = 0;
            if (promotion) {
                n++;
                promotion = false;
            }
            if (ind >= 0) {
                n += num[ind--];
            }
            if (k > 0) {
                n += k % 10;
                k /= 10;
            }
            if (n >= 10) {
                n -= 10;
                promotion = true;
            }
            res.add(n);
        }

        int l = 0;
        int r = res.size() - 1;
        while (l < r) {
            int t = res.get(l);
            res.set(l, res.get(r));
            res.set(r, t);
            l++;
            r--;
        }
        return res;
    }
}
