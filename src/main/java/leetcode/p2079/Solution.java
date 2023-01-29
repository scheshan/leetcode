package leetcode.p2079;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int cur = capacity;

        for (int i = 0; i < plants.length; i++) {
            res++;
            cur -= plants[i];

            if (i < plants.length - 1 && cur < plants[i + 1]) {
                cur = capacity;
                res += (i + 1) * 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().wateringPlants(new int[]{2, 2, 3, 3}, 5);
    }
}
