package leetcode.p244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WordDistance
 *
 * @author heshan
 * @date 2023/2/12
 */
public class WordDistance {

    private Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            List<Integer> list = map.get(word);
            if (list == null) {
                list = new ArrayList<>();
                map.put(word, list);
            }
            list.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> left = map.get(word1);
        List<Integer> right = map.get(word2);
        int res = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        while (l < left.size() && r < right.size()) {
            res = Math.min(res, Math.abs(left.get(l) - right.get(r)));
            if (left.get(l) < right.get(r)) {
                l++;
            } else {
                r++;
            }
        }
        return res;
    }
}
