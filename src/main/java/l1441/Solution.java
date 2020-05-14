package l1441;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new LinkedList<>();

        int i = 0;
        int j = 0;

        while (i < n && j < target.length) {
            if (target[j] != i + 1) {
                res.add("Push");
                res.add("Pop");
                i++;
            } else {
                res.add("Push");
                i++;
                j++;
            }
        }
        return res;
    }
}
