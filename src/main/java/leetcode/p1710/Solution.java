package leetcode.p1710;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> {
            return Integer.compare(o2[1], o1[1]);
        });

        int res = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int size = Math.min(truckSize, boxTypes[i][0]);
            res += size * boxTypes[i][1];
            truckSize -= size;
        }
        return res;
    }
}
