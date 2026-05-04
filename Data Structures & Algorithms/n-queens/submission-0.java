class Solution {
   List<List<String>> answer;

    public List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();

        int[] position = new int[n];
        Arrays.fill(position, -1);
        populateAnswer(position, n , 0);

        return answer;
    }

    private void populateAnswer(int[] position, int n, int currIndex) {
        if(currIndex == n) {
            answer.add(getListOfString(position));
            return;
        }

        for(int i = 0 ; i < n ; i++) {
            position[currIndex] = i;
            if(isValid(position, currIndex)) {
                populateAnswer(position, n, currIndex + 1);
            }
            position[currIndex] = -1;
        }
    }

    private List<String> getListOfString(int[] position) {
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < position.length ; i++) {
            StringBuilder strBuilder = new StringBuilder();
            for(int j = 0 ; j < position.length ; j++) {
                if(j == position[i]) {
                    strBuilder.append("Q");
                } else {
                    strBuilder.append(".");
                }
            }
            list.add(strBuilder.toString());
        }

        return list;
    }

    private boolean isValid(int[] position, int currIndex) {
        int[] unavailable = new int[position.length];
        for(int i = 0 ; i < currIndex ; i++) {
            if(position[i] == position[currIndex]) {
                return false;
            }
            if (Math.abs(position[i] - position[currIndex]) == Math.abs(i - currIndex)) {
                return false;
            }
        }
        return true;
    }
}
