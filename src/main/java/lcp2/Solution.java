package lcp2;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int[] fraction(int[] cont) {
        int x = cont[cont.length - 1];
        int y = 1;

        for (int i = cont.length - 2; i >= 0; i--) {
            int t = y;
            y = x;
            x = x * cont[i] + t;
        }

        return new int[]{x, y};
    }
}
