package L789;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/19
 */
public class Solution {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);

        for (int[] g : ghosts) {
            int d = Math.abs(target[0] - g[0]) + Math.abs(target[1] - g[1]);
            if (d <= distance) {
                return false;
            }
        }
        return true;
    }
}
