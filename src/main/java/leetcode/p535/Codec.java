package leetcode.p535;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Codec {

    private int cur;

    private Map<String, String> longMap = new HashMap<>();
    private Map<String, String> shortMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longMap.containsKey(longUrl)) {
            return longMap.get(longUrl);
        }

        cur++;
        String res = String.valueOf(cur);
        longMap.put(longUrl, res);
        shortMap.put(res, longUrl);

        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortMap.get(shortUrl);
    }
}
