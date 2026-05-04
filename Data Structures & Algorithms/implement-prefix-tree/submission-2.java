class PrefixTree {

    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node child = curr.getChild(c);
            if (child == null) {
                child = new Node(curr.getStr(), c);
                curr.getChildren().put(c, child);
            }
            curr = child;
        }
        curr.setEnd(true);
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node child = curr.getChild(c);
            if (child == null) {
                return false;
            } else {
                curr = child;
            }
        }
        return curr.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node child = curr.getChild(c);
            if (child == null) {
                return false;
            } else {
                curr = child;
            }
        }
        return true;
    }

    private class Node {
        boolean end;
        String str;
        Map<Character, Node> children;

        Node() {
            children = new HashMap<>();
            str = "";
        }

        Node(String strSoFar, Character ch) {
            children = new HashMap<>();
            this.str = strSoFar + String.valueOf(ch);
        }

        String getStr() {
            return str;
        }

        Map<Character, Node> getChildren() {
            return children;
        }

        Node getChild(char c) {
            return children.get(c);
        }

        void setEnd(boolean end) {
            this.end = end;
        }

        boolean isEnd() {
            return end;
        }
    }
}
