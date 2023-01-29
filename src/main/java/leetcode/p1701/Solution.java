package leetcode.p1701;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public double averageWaitingTime(int[][] customers) {
        double total = 0;

        int time = 0;
        for (int[] customer : customers) {
            if (time < customer[0]) {
                total += customer[1];
                time = customer[0];
            } else {
                total += time- customer[0] + customer[1];
            }
            time += customer[1];
        }

        return total / customers.length;
    }
}
