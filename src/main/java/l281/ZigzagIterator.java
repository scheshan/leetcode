package l281;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class ZigzagIterator {

    private int i = 0;

    private int j = 0;

    private List<Integer> v1;

    private List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }

        int res;
        if (i >= v1.size()) {
            res = v2.get(j++);
        } else if (j >= v2.size()) {
            res = v1.get(i++);
        } else if (i == j) {
            res = v1.get(i++);
        } else {
            res = v2.get(j++);
        }

        return res;
    }

    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }
}
