class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> alphaIndex = new HashMap<>();
        for(int i = 0 ; i < order.length() ; i++) {
            alphaIndex.put(order.charAt(i), i);
        }
        for(int i = 1 ; i < words.length ; i++) {
            boolean isSorted = isAlienSorted(words[i - 1], words[i], alphaIndex);
            if(!isSorted) {
                return false;
            }
        }
        return true;
     }

    private boolean isAlienSorted(String word1, String word2, Map<Character, Integer> alphaIndex) {
        int index = 0;
        while(index < word1.length()) {
            if(index == word2.length()) {
                return false;
            }
            int char1Index = alphaIndex.get(word1.charAt(index));
            int char2Index = alphaIndex.get(word2.charAt(index));
            if(char1Index > char2Index) {
                return false;
            }
            if(char1Index < char2Index) {
                return true;
            }
            index++;
        }
        return true;
    }
}