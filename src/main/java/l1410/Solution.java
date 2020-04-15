package l1410;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/15
 */
public class Solution {

    private int index;

    private StringBuilder res = new StringBuilder();

    private State current;

    private State normal = new NormalState();

    private State html = new HtmlState();

    public String entityParser(String text) {
        current = normal;

        while (index < text.length()) {
            current.read(text);
        }

        return res.toString();
    }

    private interface State {

        void read(String text);
    }

    private class NormalState implements State {

        @Override
        public void read(String text) {
            if (text.charAt(index) == '&') {
                current = html;
            } else {
                res.append(text.charAt(index++));
            }
        }
    }

    private class HtmlState implements State {

        private StringBuilder inner = new StringBuilder();

        private Map<String, String> mapping;

        public HtmlState() {
            mapping = new HashMap<>();
            mapping.put("&quot;", "\"");
            mapping.put("&apos;", "'");
            mapping.put("&amp;", "&");
            mapping.put("&gt;", ">");
            mapping.put("&lt;", "<");
            mapping.put("&frasl;", "/");
        }

        @Override
        public void read(String text) {
            inner.append(text.charAt(index++));
            if (inner.charAt(inner.length() - 1) == ';' || index == text.length()) {
                String str = inner.toString();
                if (mapping.containsKey(str)) {
                    res.append(mapping.get(str));
                } else {
                    res.append(str);
                }

                inner.delete(0, inner.length());
                current = normal;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().entityParser("&amp; is an HTML entity but &ambassador; is not.");
    }
}
