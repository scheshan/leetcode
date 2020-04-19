package l1018;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>(A.length);

        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            cur = ((cur << 1) + A[i]) % 5;
            res.add(cur == 0);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Boolean> res = new Solution().prefixesDivBy5(new int[]{0, 1, 1});
        System.out.println(res);
    }
}
