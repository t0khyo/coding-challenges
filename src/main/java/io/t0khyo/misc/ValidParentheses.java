package io.t0khyo.misc;

import java.util.Stack;

public class ValidParentheses {
    private static boolean isOpenParenthesis(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (isOpenParenthesis(ch)) {
                stack.push(ch);
            } else if (!stack.isEmpty() && isMatchingPair(stack.peek(), ch)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

