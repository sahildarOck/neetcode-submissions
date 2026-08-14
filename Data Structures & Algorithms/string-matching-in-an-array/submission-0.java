class Solution {
    public List<String> stringMatching(String[] words) {
        // Sort the words based on length
        Arrays.sort(words, Comparator.comparingInt(String::length));

        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i++) {
            String currWord = words[i];
            for(int j = i + 1 ; j < words.length ; j++) {
                if(words[j].contains(currWord)) {
                    ans.add(currWord);
                    break;
                }
            }
        }
        return ans;
    }
}