package l500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/27
 */
public class Solution {

    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);
        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);
        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);

        List<String> list = new LinkedList<>();

        for (String word : words) {
            int row = 0;

            boolean match = true;
            for (int j = 0; j < word.length(); j++) {
                char ch = Character.toLowerCase(word.charAt(j));
                if (row == 0) {
                    row = map.get(ch);
                } else if (row != map.get(ch)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                list.add(word);
            }
        }

        String[] res = new String[list.size()];
        int i = 0;
        for (String word : list) {
            res[i++] = word;
        }

        return res;
    }
}
