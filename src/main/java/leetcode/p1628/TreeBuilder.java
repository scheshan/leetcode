package leetcode.p1628;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/20
 */
class TreeBuilder {
    class NumberNode extends Node {

        int value;

        @Override
        public int evaluate() {
            return value;
        }
    }

    class OpNode extends Node {
        String op;
        Node left;
        Node right;

        @Override
        public int evaluate() {
            int l = left.evaluate();
            int r = right.evaluate();

            switch (op) {
                case "+":
                    return l + r;
                case "-":
                    return l - r;
                case "*":
                    return l * r;
                default:
                    return l / r;
            }
        }
    }

    Node buildTree(String[] postfix) {
        Deque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < postfix.length; i++) {
            String str = postfix[i];
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                Node right = deque.removeLast();
                Node left = deque.removeLast();

                OpNode node = new OpNode();
                node.op = str;
                node.left = left;
                node.right = right;
                deque.addLast(node);
            } else {
                NumberNode node = new NumberNode();
                node.value = Integer.parseInt(str);
                deque.addLast(node);
            }
        }

        return deque.remove();
    }

    public static void main(String[] args) {
        Node node = new TreeBuilder().buildTree(new String[]{"3", "4", "+", "2", "*", "7", "/"});
        System.out.println(node.evaluate());
    }
}
