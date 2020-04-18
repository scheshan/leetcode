package l1337;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Row> list = new ArrayList<>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            int[] items = mat[i];
            int count = 0;
            for (int n : items) {
                if (n == 1) {
                    count++;
                } else {
                    break;
                }
            }
            list.add(new Row(i, count));
        }

        list.sort(new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                if (o1.count != o2.count) {
                    return o1.count - o2.count;
                }
                return o1.index - o2.index;
            }
        });

        int[] res = new int[k];
        int ind = 0;
        while (ind < k) {
            res[ind] = list.get(ind).index;
            ind++;
        }
        return res;
    }

    private class Row {

        private int index;

        private int count;

        public Row(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
