package l1404;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/15
 */
public class Solution {

    public int numSteps(String s) {
        char[] arr = s.toCharArray();
        int i = arr.length - 1;
        int res = 0;
        int ones = 0;

        while (i > 0) {
            while (i >= 0 && arr[i] == '1') {
                ones++;
                i--;
            }

            if (ones == 0) {
                res++;
                i--;
            } else {
                if (i >= 0) {
                    arr[i] = '1';
                }
                res += ones + 1;
                ones = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().numSteps("1");
        System.out.println(res);
    }
}
