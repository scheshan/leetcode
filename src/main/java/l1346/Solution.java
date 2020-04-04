package l1346;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/4
 */
public class Solution {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num * 2)) {
                return true;
            }
            if ((num & 1) == 0 && set.contains(num / 2)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}
