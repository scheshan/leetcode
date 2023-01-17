package leetcode.p1773;

import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int ind = 0;
        switch (ruleKey) {
            case "color":
                ind = 1;
                break;
            case "name":
                ind = 2;
                break;
        }

        for (List<String> item : items) {
            if (ruleValue.equals(item.get(ind))) {
                res++;
            }
        }
        return res;
    }
}
