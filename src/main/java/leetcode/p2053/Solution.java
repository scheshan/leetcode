package leetcode.p2053;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.compute(str, (key, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        int ind = 0;
        for (String str : arr) {
            if (map.get(str) == 1) {
                ind++;
                if (ind == k) {
                    return str;
                }
            }
        }
        return "";
    }
}
