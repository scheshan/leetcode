package l374;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ans = guess(mid);

            if (ans == 0) {
                return mid;
            } else if (ans > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = new Solution().guessNumber(10);
        System.out.println(res);
    }
}
