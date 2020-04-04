package l1010;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/4
 */
public class Solution {

    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];

        for (int num : time) {
            count[(num % 60)]++;
        }

        int res = 0;
        for (int i = 1; i <= 29; i++) {
            res += count[i] * count[60 - i];
        }
        res += count[0] * (count[0] - 1) / 2;
        res += count[30] * (count[30] - 1) / 2;

        return res;
    }

    public static void main(String[] args) {
        //new Solution().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
    }
}
