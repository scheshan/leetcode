package leetcode.p500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public String[] findWords(String[] words) {
        Map<Character, Integer> map = initMap();
        List<String> list = new ArrayList<>();

        for (String word : words) {
            if (valid(map, word)) {
                list.add(word);
            }
        }

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private Map<Character, Integer> initMap() {
        int[] arr = new int[]{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            res.put((char) ('a' + i), arr[i]);
            res.put((char) ('A' + i), arr[i]);
        }
        return res;
    }

    private boolean valid(Map<Character, Integer> map, String word) {
        int ind = map.get(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (map.get(word.charAt(i)) != ind) {
                return false;
            }
        }
        return true;
    }
}
