package l1236;

import java.net.URI;
import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/18
 */
public class Solution {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visit = new HashSet<>();
        dfs(startUrl, visit, htmlParser);

        return new ArrayList<>(visit);
    }

    private void dfs(String url, Set<String> visit, HtmlParser parser) {
        if (visit.contains(url)) {
            return;
        }

        String host = URI.create(url).getHost();

        visit.add(url);

        List<String> urls = parser.getUrls(url);
        for (String u : urls) {
            if (Objects.equals(URI.create(u).getHost(), host)) {
                dfs(u, visit, parser);
            }
        }
    }
}
