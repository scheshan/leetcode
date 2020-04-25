package l119;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(1);
        }

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().getRow(0);
    }
}
