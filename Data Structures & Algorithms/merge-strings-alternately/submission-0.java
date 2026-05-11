class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;

        char[] chArr = new char[word1.length() + word2.length()];
        int chArrIndex = 0;
        boolean firstTurn = true;
        while(index1 < word1.length() && index2 < word2.length()) {
            if(firstTurn) {
                chArr[chArrIndex++] = word1.charAt(index1++);
            } else {
                chArr[chArrIndex++] = word2.charAt(index2++);
            }
            firstTurn = !firstTurn;
        }
        while(index1 < word1.length()) {
            chArr[chArrIndex++] = word1.charAt(index1++);
        }
        while(index2 < word2.length()) {
            chArr[chArrIndex++] = word2.charAt(index2++);
        }

        return new String(chArr);
    }
}