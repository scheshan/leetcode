package l702;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/28
 */
public class Solution {

    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            right <<= 1;
        }

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
