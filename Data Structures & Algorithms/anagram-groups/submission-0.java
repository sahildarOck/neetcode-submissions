class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        List<String> strList;
        String charFreq;
        for(String str : strs) {
            charFreq = getCharFreq(str);
            anagramsMap.putIfAbsent(charFreq, new ArrayList<>());
            anagramsMap.get(charFreq).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        anagramsMap.forEach((k, v) -> result.add(v));

        return result;
    }

    private String getCharFreq(String str) {
        int[] charFreq = new int[26];
        char[] charArr = str.toCharArray();

        for(char c : charArr) {
            charFreq[c - 'a']++;
        }

        return Arrays.toString(charFreq);
    }
}
