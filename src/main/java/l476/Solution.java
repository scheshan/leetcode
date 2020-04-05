package l476;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/5
 */
public class Solution {

    public int findComplement(int num) {
        int res = 0;

        int i = 0;
        while (num != 0) {
            int n = num & 1;
            n = n == 1 ? 0 : 1;

            num = num >> 1;

            res = res | (n << i);

            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().findComplement(5);
    }
}
