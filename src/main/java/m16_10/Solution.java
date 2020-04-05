package m16_10;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/5
 */
public class Solution {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] count = new int[102];

        for (int i = 0; i < birth.length; i++) {
            count[birth[i] % 100]++;
            count[death[i] % 100 + 1]--;
        }

        int max = 0;
        int cur = 0;
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            cur += count[i];

            if (cur > max) {
                max = cur;
                res = i;
            }
        }

        return 1900 + res;
    }
}
