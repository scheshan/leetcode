package l1560;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/8/28
 */
public class Solution {

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();

        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                res.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                res.add(i);
            }
            for (int i = start; i <= n; i++) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        final List<Integer> res = new Solution().mostVisited(4, new int[]{1, 3, 1, 2});
        System.out.println(res);
    }
}
