class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqArr = new int[26];

        for (char c : tasks) {
            freqArr[c - 'A']++;
        }

        // calc freq and store in max heap
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (freqArr[i] > 0) {
                pq.add(freqArr[i]);
            }
        }

        // pop the first -> reduce by 1 and push to queue (freq)
        Queue<int[]> q = new LinkedList<>();

        int interval = 0;

        int pqFreq, qFreq;
        while (!pq.isEmpty()) {
            pqFreq = pq.remove();
            pqFreq--;
            interval++;
            if (pqFreq > 0) {
                q.add(new int[] { interval, pqFreq });
            }

            while (pq.isEmpty() && !q.isEmpty() && (interval - q.peek()[0]) < n) {
                interval++;
            }

            while (!q.isEmpty() && (interval - q.peek()[0]) >= n) {
                pq.add(q.remove()[1]);
            }
        }
        return interval;
    }
}
