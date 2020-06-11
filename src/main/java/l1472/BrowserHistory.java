package l1472;

/**
 * BrowserHistory
 *
 * @author heshan
 * @date 2020/6/11
 */
public class BrowserHistory {

    private String[] history;

    private int cur;

    private int end;

    public BrowserHistory(String homepage) {
        history = new String[5000];
        cur = 0;
        end = 1;
        history[0] = homepage;
    }

    public void visit(String url) {
        cur++;
        history[cur] = url;
        end = cur + 1;
    }

    public String back(int steps) {
        cur -= steps;
        if (cur < 0) {
            cur = 0;
        }
        return history[cur];
    }

    public String forward(int steps) {
        cur += steps;
        if (cur >= end) {
            cur = end - 1;
        }
        return history[cur];
    }
}
