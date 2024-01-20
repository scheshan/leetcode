package leetcode.p374;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
class GuessGame {
    int guess(int num) {
        return 0;
    }
}

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int l = 1, r = n;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
