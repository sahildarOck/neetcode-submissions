class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incomingTrustCount = new int[n + 1];
        boolean[] outgoingTrustExists = new boolean[n + 1];

        for(int[] t : trust) {
            incomingTrustCount[t[1]]++;
            outgoingTrustExists[t[0]] = true;
        }

        for(int i = 1 ; i < n + 1 ; i++) {
            if(incomingTrustCount[i] == (n - 1) && !outgoingTrustExists[i]) {
                return i;
            }
        }
        return -1;
    }
}