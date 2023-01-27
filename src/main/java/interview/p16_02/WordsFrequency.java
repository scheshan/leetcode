package interview.p16_02;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class WordsFrequency {

    private Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for (String word : book) {
            map.compute(word, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }
    }

    public int get(String word) {
        if(map.containsKey(word)) {
            return map.get(word);
        }
        return 0;
    }
}
