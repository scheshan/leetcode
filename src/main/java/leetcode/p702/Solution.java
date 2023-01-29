package leetcode.p702;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    interface ArrayReader {
        public int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = 10000;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int n = reader.get(mid);
            if (n == target) {
                return mid;
            } else if (n < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
