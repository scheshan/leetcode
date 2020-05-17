package l5413;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/17
 */
public class Solution {

    public String arrangeWords(String text) {
        String[] arr = text.split(" ");

        List<Item> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            list.add(new Item(arr[i].toLowerCase(), i));
        }

        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                int d = o1.word.length() - o2.word.length();
                if (d != 0) {
                    return d;
                }
                return o1.index - o2.index;
            }
        });

        StringBuilder sb = new StringBuilder(text.length());
        for (Item item : list) {
            if (sb.length() == 0) {
                char[] chars = item.word.toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                sb.append(new String(chars));
            } else {
                sb.append(" ");
                sb.append(item.word);
            }
        }

        return sb.toString();
    }

    private class Item {

        private String word;

        private int index;

        public Item(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}
