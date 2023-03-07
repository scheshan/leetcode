package leetcode.p2433;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/7
 */
public class Solution {

    public int[] findArray(int[] pref) {
        int pre = 0;

        for (int i = 0; i < pref.length; i++) {
            pref[i] = pre ^ pref[i];
            pre = pre ^ pref[i];
        }

        return pref;
    }
}
