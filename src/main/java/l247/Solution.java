package l247;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public List<String> findStrobogrammatic(int n) {
        return find(n, n);
    }

    private List<String> find(int n, int max) {
        List<String> res = new LinkedList<>();
        if (n == 0) {
            res.add("");
            return res;
        }
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }

        List<String> inner = find(n - 2, max);
        for (String str : inner) {
            if (n != max) {
                res.add("0" + str + "0");
            }
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
        }
        return res;
    }
}
