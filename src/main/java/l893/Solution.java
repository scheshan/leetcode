package l893;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/8
 */
public class Solution {

    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();

        for (String s : A) {
            int[] count = new int[52];

            for (int i = 0; i < s.length(); i++) {
                int ind = s.charAt(i) - 'a' + ((i % 2) == 0 ? 26 : 0);
                count[ind]++;
            }

            set.add(Arrays.toString(count));
        }

        return set.size();
    }
}
