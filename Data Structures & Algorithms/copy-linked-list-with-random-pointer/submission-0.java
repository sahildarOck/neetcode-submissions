/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        Map<Node, Node> oldToCopyMap = new HashMap<>();
        Node ans = new Node(head.val);
        oldToCopyMap.put(head, ans);
        if(head.random != null) {
            ans.random = oldToCopyMap.getOrDefault(head.random,  new Node(head.random.val));
            oldToCopyMap.putIfAbsent(head.random, ans.random);
        }
        
        Node prevNode = ans;
        Node index = head.next;
        while(index != null) {
            Node newNode = oldToCopyMap.getOrDefault(index,  new Node(index.val));
            oldToCopyMap.putIfAbsent(index, newNode);
            if(prevNode != null) {
                prevNode.next = newNode;
            }
            prevNode = newNode;

            if(index.random != null) {
                newNode.random = oldToCopyMap.getOrDefault(index.random, new Node(index.random.val));
                oldToCopyMap.putIfAbsent(index.random, newNode.random);
            }
            index = index.next;
        }

        return ans;
    }
}
