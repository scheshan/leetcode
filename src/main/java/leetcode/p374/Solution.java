package leetcode.p374;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
