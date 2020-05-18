package l1409;

import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/18
 */
public class Solution {

    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        int[] res = new int[queries.length];
        int i = 0;
        for (int q : queries) {
            int ind = list.indexOf(q);

            res[i++] = ind;

            list.remove((Object) q);
            list.addFirst(q);
        }

        return res;
    }
}
