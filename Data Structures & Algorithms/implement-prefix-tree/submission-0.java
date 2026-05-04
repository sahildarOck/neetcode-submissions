class PrefixTree {

    private Node root;

    public PrefixTree() {
        root = new Node(null);
    }

    public void insert(String word) {
        char[] chrArr = word.toCharArray();
        Node currNode = root;
        for (char c : chrArr) {
            Node child;
            if (!currNode.children.containsKey(c)) {
                child = new Node(c);
                currNode.children.put(c, child);
            } else {
                child = currNode.children.get(c);
            }
            currNode = child;
        }
        currNode.wordCompleted = true;

        // System.out.println("Printing: ");
        // printNodes(root);
    }

    public boolean search(String word) {
        char[] chrArr = word.toCharArray();
        Node currNode = root;

        for (char c : chrArr) {
            if (!currNode.children.containsKey(c)) {
                return false;
            }
            currNode = currNode.children.get(c);
        }
        return currNode.wordCompleted;
    }

    public boolean startsWith(String prefix) {
        char[] chrArr = prefix.toCharArray();
        Node currNode = root;

        for (char c : chrArr) {
            if (!currNode.children.containsKey(c)) {
                return false;
            }
            currNode = currNode.children.get(c);
        }
        return true;
    }

    private void printNodes(Node node) {
        if (node == null) {
            return;
        }
        Node currNode = node;
        System.out.println(currNode.ch);
        for (int i = 0; i < currNode.children.size(); i++) {
            System.out.println("currNode.children.size(): " + currNode.children.size());
            printNodes(currNode.children.get(i));
        }
    }

    private class Node {
        private Character ch;
        private Map<Character, Node> children;
        private boolean wordCompleted;

        Node(Character ch) {
            this.ch = ch;
            children = new HashMap<>();
        }
    }
}
