package l1106;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    private int index;

    public boolean parseBoolExpr(String expression) {
        return readExpr(expression);
    }

    private boolean readNot(String expression) {
        index += 2;

        boolean b = readExpr(expression);

        index++;

        return !b;
    }

    private boolean readAnd(String expression) {
        index += 2;

        boolean res = true;
        while (expression.charAt(index) != ')') {
            res = readExpr(expression) && res;

            if (expression.charAt(index) == ',') {
                index++;
            }
        }

        index++;
        return res;
    }

    private boolean readOr(String expression) {
        index += 2;

        boolean res = false;
        while (expression.charAt(index) != ')') {
            res = readExpr(expression) || res;

            if (expression.charAt(index) == ',') {
                index++;
            }
        }

        index++;
        return res;
    }

    private boolean readExpr(String expression) {
        if (expression.charAt(index) == '!') {
            return readNot(expression);
        } else if (expression.charAt(index) == '&') {
            return readAnd(expression);
        } else if (expression.charAt(index) == '|') {
            return readOr(expression);
        } else if (expression.charAt(index) == 't') {
            index++;
            return true;
        } else {
            index++;
            return false;
        }
    }

    public static void main(String[] args) {
        new Solution().parseBoolExpr("|(&(t,f,t),!(t))");
    }
}
