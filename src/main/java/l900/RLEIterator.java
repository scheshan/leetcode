package l900;

/**
 * RLEIterator
 *
 * @author heshan
 * @date 2020/4/16
 */
public class RLEIterator {

    private int[] nums;

    private int cur;

    public RLEIterator(int[] A) {
        nums = A;
    }

    public int next(int n) {
        boolean flag = false;

        while (n > 0 && cur < nums.length) {
            if (nums[cur] <= n) {
                n -= nums[cur];
                nums[cur] = 0;
                cur += 2;
                flag = true;
            } else {
                nums[cur] -= n;
                n = 0;
                flag = false;
            }
        }

        if (n == 0) {
            return flag ? nums[cur - 1] : nums[cur + 1];
        } else {
            return -1;
        }
    }
}
