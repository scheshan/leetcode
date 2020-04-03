package l1394;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/3
 */
public class Solution {

    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int i = 1; i <= 500; i++) {
            count[i] = i;
        }

        for (int num : arr) {
            count[num]--;
        }

        for (int i = count.length - 1; i >= 1; i--) {
            if (count[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
