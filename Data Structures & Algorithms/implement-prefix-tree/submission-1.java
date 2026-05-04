class PrefixTree {

   TrieNode root;
    public PrefixTree() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        char[] charArr = word.toCharArray();
        TrieNode curr = root;
        for(int i = 0 ; i < charArr.length ; i++) {
            TrieNode child = curr.children[charArr[i] - 'a'];
            if(child == null) {
                child = new TrieNode();
                curr.children[charArr[i] - 'a'] = child;
            }
            curr = child;
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        char[] charArr = word.toCharArray();
        TrieNode curr = root;
        for(int i = 0 ; i < charArr.length ; i++) {
            TrieNode child = curr.children[charArr[i] - 'a'];
            if(child == null) {
                return false;
            }
            curr = child;
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        char[] charArr = prefix.toCharArray();
        TrieNode curr = root;
        for(int i = 0 ; i < charArr.length ; i++) {
            TrieNode child = curr.children[charArr[i] - 'a'];
            if(child == null) {
                return false;
            }
            curr = child;
        }
        return true;
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }
}
