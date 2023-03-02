package leetcode.p1184;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n1 = 0;
        int n2 = 0;

        int ind = start;
        while (ind != destination) {
            n1 += distance[ind];
            ind++;
            if (ind == distance.length) {
                ind = 0;
            }
        }

        ind = start;
        while (ind != destination) {
            ind--;
            if (ind < 0) {
                ind = distance.length - 1;
            }
            n2 += distance[ind];
        }

        return Math.min(n1, n2);
    }
}
