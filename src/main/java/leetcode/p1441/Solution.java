package leetcode.p1441;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();

        int ind = 0;
        for (int i = 1; i <= n && ind < target.length; i++) {
            if (i < target[ind]) {
                res.add("Push");
                res.add("Pop");
            } else {
                res.add("Push");
                ind++;
            }
        }
        return res;
    }
}
