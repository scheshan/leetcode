package l1253;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> l1 = new ArrayList<>(colsum.length);
        List<Integer> l2 = new ArrayList<>(colsum.length);

        for (int i = 0; i < colsum.length; i++) {
            int n = colsum[i];
            if (n == 0) {
                l1.add(0);
                l2.add(0);
            } else if (n == 2) {
                l1.add(1);
                l2.add(1);

                upper--;
                lower--;
            } else {
                if (upper > lower) {
                    upper--;
                    l1.add(1);
                    l2.add(0);
                } else {
                    lower--;
                    l1.add(0);
                    l2.add(1);
                }
            }
            if (upper < 0 || lower < 0) {
                return Collections.EMPTY_LIST;
            }
        }

        if (upper == 0 && lower == 0) {
            List<List<Integer>> res = new ArrayList<>(2);
            res.add(l1);
            res.add(l2);
            return res;
        }
        return Collections.EMPTY_LIST;
    }
}
