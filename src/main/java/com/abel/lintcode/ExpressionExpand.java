package com.abel.lintcode;

import java.util.Stack;

/**
 * Created by sunzqc on 2017/8/8 11:18.
 * Given an expression s includes numbers, letters and brackets.
 * Number represents the number of repetitions inside the brackets(can be a string or another expression)．
 * Please expand expression to be a string.
 * <p>
 * s = abc3[a] return abcaaa
 * s = 3[abc] return abcabcabc
 * s = 4[ac]dy, return acacacacdy
 * s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
 */
public class ExpressionExpand {


    /**
     * @param s an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        Stack<Object> stack = new Stack<>();
        char[] arr = s.toCharArray();

        int num = 0;
        for (char c : arr) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                stack.push(Integer.valueOf(num));
                num = 0;
            } else if (c == ']') {
                popStack(stack);
            } else {
                stack.push(c);
            }
        }
        popStack(stack);
        return stack.pop().toString();
    }

    private void popStack(Stack<Object> stack) {
        StringBuilder add = new StringBuilder();
        int count;
        Stack<Object> buffer = new Stack<Object>();
        while (!stack.isEmpty() && stack.peek() instanceof Integer == false) {
            buffer.push(stack.pop());
        }
        while (!buffer.isEmpty()) {
            add.append(buffer.pop());
        }

        count = stack.isEmpty() ? 1 : (Integer) stack.pop();
        StringBuilder part = new StringBuilder(add);
        if (count > 0) {
            for (int i = 0; i < count - 1; i++)
                add.append(part);
            stack.push(add);// reput
        }
    }
}
