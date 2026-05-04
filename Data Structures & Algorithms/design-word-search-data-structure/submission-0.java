class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        char[] chrArr = word.toCharArray();

        Node curr = root;
        for (char c : chrArr) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        curr.completeWord = true;
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] chrArr, int index, Node curr) {
        if (index == chrArr.length) {
            return curr.completeWord;
        }
        char c = chrArr[index];
        if (c == '.') {
            for (Map.Entry<Character, Node> entry : curr.children.entrySet()) {
                if (search(chrArr, index + 1, entry.getValue())) {
                    return true;
                }
            }
            return false;
        } else {
            Node next = curr.children.get(c);
            return next != null && search(chrArr, index + 1, next);
        }
    }

    private class Node {
        Map<Character, Node> children;
        boolean completeWord;

        Node() {
            children = new HashMap<>();
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */