package l728;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/24
 */
public class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (match(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean match(int n) {
        int num = n;
        while (num > 0) {
            int x = num % 10;

            if (x == 0 || n % x > 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
