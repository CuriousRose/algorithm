package leet_code.leet_code_0201_0250.leet_code_0208;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树
 */
class Trie {

    Node root;

    public Trie() {
        root = new Node(' ');
    }


    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.map.containsKey(c)) {
                node.map.put(c, new Node(c));
            }
            node = node.map.get(c);
        }
        node.end = true;
    }


    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.map.containsKey(c)) {
                return false;
            }
            node = node.map.get(c);
        }
        return node.end;
    }


    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.map.containsKey(c)) {
                return false;
            }
            node = node.map.get(c);
        }
        return true;
    }
}

class Node {
    char c;
    boolean end;
    Map<Character, Node> map = new HashMap<>();

    Node(char c) {
        this.c = c;
    }
}