package l1486;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/7/3
 */
public class Solution {

    public int xorOperation(int n, int start) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            res = res ^ (start + i * 2);
        }

        return res;
    }
}
