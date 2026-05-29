class Solution {
    public String reorganizeString(String s) {
        // Alternate placing most frequent letters
        PriorityQueue<CharNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.freq, a.freq)
        );

        int[] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++) {
            if(freq[i] > 0) {
                pq.add(new CharNode((char) (i + 'a'), freq[i]));
            }
        }

        //  while(!pq.isEmpty()) {
        //     CharNode cNode = pq.poll();
        //     System.out.println("cNode.ch: " + cNode.ch);
        //     System.out.println("cNode.freq: " + cNode.freq);
        //  }

        StringBuilder strBuilder = new StringBuilder();
        Character lastProcessedChar = null;
        boolean notPossible = false;
        while(!pq.isEmpty()) {
            CharNode cNode = pq.poll();
            CharNode temp = null;
            if(lastProcessedChar!= null && lastProcessedChar == cNode.ch) {
                if(pq.size() == 0) {
                    notPossible = true;
                    break;
                }
                temp = cNode;
                cNode = pq.poll();
            }
            strBuilder.append(cNode.ch);
            lastProcessedChar = cNode.ch;
            cNode.freq -= 1;
            if(cNode.freq > 0) {
                pq.add(cNode);
            }
            if(temp != null) {
                pq.add(temp);
            }
            temp = null;
        }

        return notPossible ? "" : strBuilder.toString();
    }

    private static class CharNode {
        char ch;
        int freq;

        CharNode(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}