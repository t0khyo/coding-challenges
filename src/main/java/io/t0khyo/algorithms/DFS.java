package io.t0khyo.algorithms;

import lombok.Data;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Data
public class DFS<T> {
    public void dfs(Node<T> startNode) {
        Deque<Node<T>> stack = new LinkedList<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                current.getNeighbors().forEach(stack::push);
            }
        }
    }

    public void dfsRecursively(Node<T> node) {
        node.setVisited(true);
        node.getNeighbors().forEach(neighbor -> {
            if(!neighbor.isVisited()){
                dfsRecursively(neighbor);
            }
        });
    }

    @Data
    public static class Node<T> {
        private final T data;
        private boolean visited;
        private List<Node<T>> neighbors;
    }
}
