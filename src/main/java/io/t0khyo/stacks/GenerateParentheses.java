package io.t0khyo.stacks;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();

        dfs(0, 0, "", n, parenthesis);

        return parenthesis;
    }

    /**
     * only add open parentheses if open < n
     * only add closed if closed < open
     * valid IFF open == close == n
     */
    private void dfs(int openP, int closedP, String s, int n, List<String> res) {
        if (openP == closedP && openP + closedP == n * 2) {
            res.add(s);
            return;
        }

        if (openP < n) {
            dfs(openP + 1, closedP, s + "(", n, res);
        }

        if (closedP < openP) {
            dfs(openP, closedP + 1, s + ")", n, res);
        }
    }
}
