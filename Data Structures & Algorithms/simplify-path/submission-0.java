class Solution {
    public String simplifyPath(String path) {
        Deque<String> canonicalPath = new ArrayDeque<>();
        int dotCount = 0;
        String[] currStrArr = path.split("/+");
        // System.out.println(Arrays.toString(currStrArr));
        for(int i = 1 ; i < currStrArr.length ; i++) {
            String curr = currStrArr[i];
            if(curr.equals(".")) {
                continue;
            }
            if(curr.equals("..")) {
                canonicalPath.pollLast();
                continue;
            }
            canonicalPath.offerLast(curr);
        }
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("/");
        while(!canonicalPath.isEmpty()) {
            strBuilder.append(canonicalPath.pollFirst());
            strBuilder.append("/");
        }
        if(strBuilder.length() > 1) {
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
        return strBuilder.toString();
    }
}