class Solution {
    private int m;
    private int n;
    private char[][] board;
    boolean[][] visited;
    Set<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        this.visited = new boolean[m][n];
        result = new HashSet<>();

        Node root = buildTrie(words);

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                populateResult(i, j, new StringBuilder(), root);
            }
        }

        return new ArrayList<>(result);
    }

    private void populateResult(int i, int j, StringBuilder strBuilder, Node node) {
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return;
        }

        char c = board[i][j];
        Node curr = node.children.get(c);
        if(curr == null) {
            return;
        }

        strBuilder.append(c);
        visited[i][j] = true;

        if(curr.isWord) {
            result.add(strBuilder.toString());
            curr.isWord = false;
        }

        populateResult(i + 1, j, strBuilder, curr);
        populateResult(i, j + 1, strBuilder, curr);
        populateResult(i - 1, j, strBuilder, curr);
        populateResult(i, j - 1, strBuilder, curr);

        strBuilder.deleteCharAt(strBuilder.length() - 1);
        visited[i][j] = false;
    }



    private Node buildTrie(String[] words) {
        Node root = new Node();
        for(String word : words) {
            Node curr = root;
            for(char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new Node());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }
        return root;
    }

    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;
    }
}