class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Form a map for wordList such that each adjacent node differs by 1
        Map<String, Set<String>> ladderMap = new HashMap<>();

        for (String str : wordList) {
            Set<String> neighbours = new HashSet<>();
            ladderMap.put(str, neighbours);
            for (String s : wordList) {
                if (differsByOneLetter(str, s)) {
                    neighbours.add(s);
                }
            }
        }

        // ladderMap.forEach((k, v) -> System.out.println(k + ": " + v));

        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[] { endWord, "1" });

        Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            String[] curr = q.remove();
            visited.add(curr[0]);
            int length = Integer.parseInt(curr[1]);
            if (differsByOneLetter(curr[0], beginWord)) {
                // System.out.println("s: " + s);
                // System.out.println("curr[0]: " + curr[0]);
                // System.out.println("length: " + length);
                return length + 1;
            }
            for (String s : ladderMap.get(curr[0])) {
                if (visited.contains(s)) {
                    continue;
                }
                q.offer(new String[] { s, String.valueOf(length + 1) });
                // ladderMap.get(s).remove(curr[0]);
            }
        }

        return 0;
    }

    private boolean differsByOneLetter(String str1, String str2) {
        boolean oneDiff = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (oneDiff) {
                    return false;
                }
                oneDiff = true;
            }
        }

        return oneDiff;
    }
}