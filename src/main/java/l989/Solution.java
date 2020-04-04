package l989;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/4
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();

        boolean flag = false;
        int i = A.length - 1;
        while (K > 0 || i >= 0) {
            int n = K % 10;
            if (i >= 0) {
                n += A[i];
            }
            if (flag) {
                n++;
                flag = false;
            }
            if (n >= 10) {
                flag = true;
                n -= 10;
            }
            res.addFirst(n);
            K /= 10;
            i--;
        }

        if (flag) {
            res.addFirst(1);
        }
        return res;
    }
}
