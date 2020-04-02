package l726;

import java.util.Map;
import java.util.TreeMap;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/2
 */
public class Solution {

    private int index = 0;

    public String countOfAtoms(String formula) {
        Map<String, Integer> res = full(formula);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }

        return sb.toString();
    }

    private Map<String, Integer> full(String formula) {
        Map<String, Integer> res = new TreeMap<>();

        while (index < formula.length()) {
            Map<String, Integer> inner;
            if (formula.charAt(index) == '(') {
                inner = multi(formula);
            } else if (formula.charAt(index) == ')') {
                return res;
            } else {
                inner = single(formula);
            }

            for (Map.Entry<String, Integer> entry : inner.entrySet()) {
                res.compute(entry.getKey(), (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return v + entry.getValue();
                });
            }
        }

        return res;
    }

    private Map<String, Integer> single(String formula) {
        Map<String, Integer> res = new TreeMap<>();

        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(index++));
        while (index < formula.length() && formula.charAt(index) >= 'a' && formula.charAt(index) <= 'z') {
            sb.append(formula.charAt(index++));
        }

        int multi = readNumber(formula);
        res.put(sb.toString(), multi);
        return res;
    }

    private Map<String, Integer> multi(String formula) {
        Map<String, Integer> res = new TreeMap<>();

        index++; //skip (

        Map<String, Integer> inner = full(formula);

        index++; //skip )

        int multi = readNumber(formula);
        for (Map.Entry<String, Integer> entry : inner.entrySet()) {
            res.put(entry.getKey(), entry.getValue() * multi);
        }

        return res;
    }

    private int readNumber(String formula) {
        int multi = 0;
        while (index < formula.length() && formula.charAt(index) >= '0' && formula.charAt(index) <= '9') {
            if (multi == 0) {
                multi = formula.charAt(index++) - '0';
            } else {
                multi = multi * 10 + formula.charAt(index++) - '0';
            }
        }
        return Math.max(1, multi);
    }
}
