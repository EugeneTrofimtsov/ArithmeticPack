package arithmetics;

import java.util.LinkedList;

class StringParser {
    private final String expr;

    StringParser(String s) {
        if (CheckBrackets(s))
            expr = s;
        else
            throw new RuntimeException("Invalid string");
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }

    private void processOperator(LinkedList<Integer> st, char op) {
        int r = st.removeLast();
        int l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '%':
                st.add(l % r);
                break;
        }
    }

    int eval() {
        LinkedList<Integer> st = new LinkedList<Integer>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == ' ')
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                StringBuilder operand = new StringBuilder();
                while (i < expr.length() && Character.isDigit(expr.charAt(i)))
                    operand.append(expr.charAt(i++));
                --i;
                st.add(Integer.parseInt(operand.toString()));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }

    private boolean CheckBrackets(String s) {
        int leftBracket = 0;
        int rightBracket = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                ++leftBracket;
            if (s.charAt(i) == ')')
                ++rightBracket;
        }
        return leftBracket == rightBracket;
    }
}
