package leetcode.p728;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (valid(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean valid(int n) {
        int t = n;
        while (t > 0) {
            int mod = t % 10;
            if (mod == 0) {
                return false;
            }
            if (n % mod != 0) {
                return false;
            }
            t /= 10;
        }
        return true;
    }
}
