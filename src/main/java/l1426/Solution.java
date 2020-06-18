package l1426;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/18
 */
public class Solution {

    public int countElements(int[] arr) {
        int[] map = new int[1001];

        int res = 0;
        for (int n : arr) {
            map[n]++;
        }

        for (int i = 0; i < map.length - 1; i++) {
            if (map[i] > 0 && map[i + 1] > 0) {
                res += Math.max(map[i], map[i + 1]);
            }
        }

        return res;
    }
}
