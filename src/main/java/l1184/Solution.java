package l1184;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/4
 */
public class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int total = 0;
        int[] prefix = new int[distance.length + 1];
        for (int i = 0; i < distance.length; i++) {
            prefix[i + 1] = prefix[i] + distance[i];
            total += distance[i];
        }

        int p = Math.abs(prefix[destination] - prefix[start]);

        return Math.min(p, total - p);
    }

    public static void main(String[] args) {
        new Solution().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1);
    }
}
