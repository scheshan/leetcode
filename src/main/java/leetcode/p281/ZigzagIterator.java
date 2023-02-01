package leetcode.p281;

import java.util.List;

/**
 * ZigzagIterator
 *
 * @author heshan
 * @date 2023/2/1
 */
public class ZigzagIterator {

    private List<Integer> l1;

    private List<Integer> l2;

    private int ind1;

    private int ind2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.l1 = v1;
        this.l2 = v2;
    }

    public int next() {
        int res;
        if (ind1 <= ind2 && ind1 < l1.size()) {
            res = l1.get(ind1++);
        } else if (ind2 < l2.size()) {
            res = l2.get(ind2++);
        } else {
            res = l1.get(ind1++);
        }
        return res;
    }

    public boolean hasNext() {
        return ind1 < l1.size() || ind2 < l2.size();
    }
}
