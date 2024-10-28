package io.t0khyo.stacks;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    numStack.add((numStack.pop() + numStack.pop()));
                    break;
                case "-":
                    int subtractor = numStack.pop();
                    numStack.add(numStack.pop() - subtractor);
                    break;
                case "*":
                    numStack.add(numStack.pop() * numStack.pop());
                    break;
                case "/":
                    int divisor = numStack.pop();
                    numStack.push(numStack.pop() / divisor);
                    break;

                default:
                    numStack.add(Integer.parseInt(token));
            }
        }

        return numStack.peek();
    }
}
