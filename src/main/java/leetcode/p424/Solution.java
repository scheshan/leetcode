package leetcode.p424;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int l = 0;
        int r = 0;
        int maxInd = 0;
        int res = 0;
        while (r < s.length()) {
            int ind = s.charAt(r) - 'A';
            count[ind]++;
            if (count[ind] > count[maxInd]) {
                maxInd = ind;
            }
            r++;

            while (r - l - count[maxInd] > k) {
                ind = s.charAt(l++) - 'A';
                count[ind]--;
                if (ind == maxInd && count[ind] <= (r - l) >> 1) {
                    for (int i = 0; i < count.length; i++) {
                        if (count[i] > count[maxInd]) {
                            maxInd = i;
                        }
                    }
                }
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
