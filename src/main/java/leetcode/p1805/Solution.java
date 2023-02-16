package leetcode.p1805;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/16
 */
public class Solution {

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();

        int ind = 0;
        while (ind < word.length()) {
            while (ind < word.length() && !(word.charAt(ind) >= '0' && word.charAt(ind) <= '9')) {
                ind++;
            }
            int pre = ind;
            while (ind < word.length() && word.charAt(ind) >= '0' && word.charAt(ind) <= '9') {
                ind++;
            }

            if (ind > pre) {
                int mid = pre;
                while (mid < ind && word.charAt(mid) == '0') {
                    mid++;
                }

                if (mid == ind) {
                    set.add("0");
                } else {
                    set.add(word.substring(mid, ind));
                }
            }
        }
        return set.size();
    }
}
