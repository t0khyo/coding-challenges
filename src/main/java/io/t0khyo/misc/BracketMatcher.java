package io.t0khyo.misc;

import java.util.Stack;

public class BracketMatcher {
    public static void main(String[] args) {
        String str = "((hello (world))))";
        System.out.println(bracketMatcher(str));
    }

    public static int bracketMatcher(String str) {
        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0;i < str.length();i++) {
            if (str.charAt(i) == '(') {
                bracketStack.push(str.charAt(i));
                System.out.println("push: " + str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (!bracketStack.isEmpty()) {
                    bracketStack.pop();
                    System.out.println("pop: " + str.charAt(i));
                } else {
                    // Unmatched closing bracket found
                    System.out.println("final stack: " + bracketStack);
                    return 0;
                }
            }
        }

        System.out.println("final stack: " + bracketStack);

        // If stack is empty, brackets are balanced
        if (bracketStack.isEmpty()) {
            return 1;
        }

        // Stack is not empty, meaning there are unmatched opening brackets
        return 0;
    }
}
