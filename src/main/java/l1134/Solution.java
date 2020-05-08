package l1134;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/8
 */
public class Solution {

    public boolean isArmstrong(int N) {
        List<Integer> list = new LinkedList<>();
        int n = N;
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        int sum = 0;
        for (int i : list) {
            sum += Math.pow(i, list.size());
        }
        return N == sum;
    }
}
