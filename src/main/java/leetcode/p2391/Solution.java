package leetcode.p2391;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    public int garbageCollection(String[] garbage, int[] travel) {
        int c0 = 0, c1 = 0, c2 = 0;
        int t0 = 0, t1 = 0, t2 = 0;

        int pre = 0;
        for (int i = 0; i < garbage.length; i++) {
            if (i > 0) {
                pre += travel[i - 1];
            }

            for (int j = 0; j < garbage[i].length(); j++) {
                char ch = garbage[i].charAt(j);
                if (ch == 'M') {
                    c0++;
                    t0 = pre;
                } else if (ch == 'P') {
                    c1++;
                    t1 = pre;
                } else {
                    c2++;
                    t2 = pre;
                }
            }
        }

        return c0 + c1 + c2 + t0 + t1 + t2;
    }
}
