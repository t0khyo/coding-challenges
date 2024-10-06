package io.t0khyo.datastructures;

public class Trie {
    private final Node root;

    /**
     * Initialize Trie here.
     */
    public Trie() {
        root = new Node('\0');
    }

    /**
     * Inserts a word into the Trie.
     */
    public void insert(String word) {
        Node current = root;
        for (int i = 0;i < word.length();i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) current.children[c - 'a'] = new Node(c);
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    private Node getNode(String word) {
        Node current = root;
        for (int i = 0;i < word.length();i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) return null;
            current = current.children[c - 'a'];
        }
        return current;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }


    public static class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }
}
