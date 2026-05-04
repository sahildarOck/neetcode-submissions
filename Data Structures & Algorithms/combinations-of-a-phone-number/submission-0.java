class Solution {
   private Map<Character, char[]> numberCharMap;

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if(digits.equals("")) {
            return answer;
        }
        char[] digitsArr = digits.toCharArray();
        numberCharMap = new HashMap<>();

        initNumberCharMap(numberCharMap);

        populateAnswer(answer, new StringBuilder(), digitsArr, 0);

        return answer;
    }

    private void populateAnswer(List<String> answer, StringBuilder strB, char[] digitsArr, int i) {
        if(strB.length() == digitsArr.length) {
            answer.add(strB.toString());
            return;
        }

        char[] letterArr = numberCharMap.get(digitsArr[i]);
        for(int j = 0 ; j < letterArr.length ; j++) {
            strB.append(letterArr[j]);
            populateAnswer(answer, strB, digitsArr, i + 1);
            strB.deleteCharAt(strB.length() - 1);
        }
    }

    private void initNumberCharMap(Map<Character, char[]> numberCharMap) {
         numberCharMap.put('2', new char[]{'a', 'b', 'c'});
         numberCharMap.put('3', new char[]{'d', 'e', 'f'});
         numberCharMap.put('4', new char[]{'g', 'h', 'i'});
         numberCharMap.put('5', new char[]{'j', 'k', 'l'});
         numberCharMap.put('6', new char[]{'m', 'n', 'o'});
         numberCharMap.put('7', new char[]{'p', 'q', 'r', 's'});
         numberCharMap.put('8', new char[]{'t', 'u', 'v'});
         numberCharMap.put('9', new char[]{'w', 'x', 'y', 'z'});
    }
}
