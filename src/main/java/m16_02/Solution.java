package m16_02;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/16
 */
class WordsFrequency {

    private Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();

        for (String word : book) {
            map.compute(word, (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return ++v;
                }
            });
        }
    }

    public int get(String word) {
        Integer count = map.get(word);
        if (count == null) {
            return 0;
        }
        return count;
    }
}
