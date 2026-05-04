class Solution {

    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();

        for(String str : strs) {
            strBuilder.append(str.length() + ",");
        }
        strBuilder.append("@");

        for(String str : strs) {
            strBuilder.append(str);
        }
        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        List<Integer> sizes = new ArrayList<>();
        int i = 0, j = 0;
        while(str.charAt(i) != '@') {
            j = i;
            while(str.charAt(i) != ',') {
                i++;
            }
            sizes.add(Integer.parseInt(str.substring(j, i)));
            i++;
        }
        i++;
        List<String> decodedStrings = new ArrayList<>();
        for(int k = 0 ; k < sizes.size() ; k++) {
            decodedStrings.add(str.substring(i, i + sizes.get(k)));
            i += sizes.get(k);
        }

        return decodedStrings;
    }
}
