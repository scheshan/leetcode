package interview.p45;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/4
 */
public class Solution {

    public String minNumber(int[] nums) {
        List<String> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(String.valueOf(num));
        }

        arr.sort((o1, o2) -> {
            return (o1 + o2).compareTo(o2 + o1);
        });

        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
