package leet_code.leet_code_0201_0250.leet_code_0211;

/**
 * 前缀树
 */
class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node(' ');
    }


    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.list[index] == null) {
                node.list[index] = new Node(c);
            }
            node = node.list[index];
        }
        node.end = true;
    }


    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, Node node) {
        if (node == null) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node sub : node.list) {
                    if (search(word.substring(i + 1), sub)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                if (node.list[index] != null) {
                    node = node.list[index];
                } else {
                    return false;
                }
            }
        }
        return node.end;
    }
}

class Node {
    boolean end;
    char c;
    Node[] list = new Node[26];

    Node(char c) {
        this.c = c;
    }
}