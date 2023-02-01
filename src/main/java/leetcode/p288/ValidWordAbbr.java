package leetcode.p288;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ValidWordAbbr
 *
 * @author heshan
 * @date 2023/2/1
 */
public class ValidWordAbbr {

    private Map<String, Set<String>> exist = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String key = translate(word);
            Set<String> set = exist.get(key);
            if (set == null) {
                set = new HashSet<>();
                exist.put(key, set);
            }
            set.add(word);
        }
    }

    public boolean isUnique(String word) {
        String key = translate(word);
        if (!exist.containsKey(key)) {
            return true;
        }
        Set<String> set = exist.get(key);
        if (set.size() == 1 && set.contains(word)) {
            return true;
        }
        return false;
    }

    private String translate(String word) {
        if (word.length() <= 2) {
            return word;
        }
        return String.format("%s%s%s", word.charAt(0), word.length() - 2, word.charAt(word.length() - 1));
    }
}
