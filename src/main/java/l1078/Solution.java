package l1078;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new LinkedList<>();

        String[] arr = text.split(" ");

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];

            if (str.equals(first)) {
                s1.add(i);
            } else if (str.equals(second)) {
                s2.add(i);
            }
        }

        for (int i : s1) {
            if (s2.contains(i + 1)) {
                if (i + 2 < arr.length) {
                    list.add(arr[i + 2]);
                }
            }
        }

        String[] res = new String[list.size()];
        int i = 0;
        for (String str : list) {
            res[i++] = str;
        }

        return res;
    }
}
