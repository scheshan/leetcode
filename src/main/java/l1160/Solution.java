package l1160;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/17
 */
public class Solution {

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charMap = buildCharMap(chars);

        int result = 0;
        for (String word : words) {
            Map<Character, Integer> wordMap = buildCharMap(word);
            if (match(wordMap, charMap)) {
                result += word.length();
            }
        }

        return result;
    }

    private Map<Character, Integer> buildCharMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.compute(word.charAt(i), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        return map;
    }

    private boolean match(Map<Character, Integer> wordMap, Map<Character, Integer> charMap) {
        for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
            Integer charCount = charMap.get(entry.getKey());
            if (charCount == null) {
                return false;
            }
            if (charCount < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
