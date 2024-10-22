package io.t0khyo.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSumInABinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            long levelSum = 0;
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            heap.add(levelSum);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.size() == k ? heap.peek() : -1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

