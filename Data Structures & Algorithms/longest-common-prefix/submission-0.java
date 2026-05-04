class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }

        StringBuilder strBuilder = new StringBuilder(strs[0]);
        for(int i = 1 ; i < strs.length ; i++) {
            updateCommonPrefix(strs[i], strBuilder);
        }

        return strBuilder.toString();
    }

    private void updateCommonPrefix(String str, StringBuilder strBuilder) {
        if(strBuilder.length() > str.length()) {
            strBuilder.delete(str.length(), strBuilder.length());
        }
        for(int i = 0 ; i < str.length() && i < strBuilder.length() ; i++) {
            if(strBuilder.charAt(i) != str.charAt(i)) {
                strBuilder.delete(i, strBuilder.length());
                return;
            }
        }
    }
 }