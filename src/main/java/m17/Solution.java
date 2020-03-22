package m17;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] printNumbers(int n) {
        int num = (int) Math.pow(10, n) - 1;

        int[] result = new int[num];
        for (int i = 0; i < result.length; i++) {
            result[i] = i +1;
        }

        return result;
    }
}
