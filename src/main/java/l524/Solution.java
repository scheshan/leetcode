package l524;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/19
 */
public class Solution {

    public String findLongestWord(String s, List<String> d) {
        String result = "";

        List<Integer> pointers = new ArrayList<>(d.size());
        for (int i = 0; i < d.size(); i++) {
            pointers.add(0);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            for (int j = 0; j < pointers.size(); j++) {
                String str = d.get(j);
                int pointer = pointers.get(j);

                if (pointer < str.length()) {
                    if (ch == str.charAt(pointer)) {
                        pointer++;
                        pointers.set(j, pointer);
                    }
                    if (pointer == str.length()) {
                        if (str.length() > result.length()) {
                            result = str;
                        } else if (str.length() == result.length()) {
                            if (str.compareTo(result) < 0) {
                                result = str;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");

        new Solution().findLongestWord("abpcplea", d);
    }
}
