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
        if (head == null) {
            return null;
        }
        Node rear = head;
        Node front = head.next;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node newHead = new Node(rear.val);
        Node newRearNode = newHead;
        nodeMap.put(head, newHead);
        while (front != null) {
            // copy and create a new node
            Node newFrontNode = new Node(front.val);

            nodeMap.put(front, newFrontNode);

            newRearNode.next = newFrontNode;
            newRearNode = newFrontNode;

            rear = front;
            front = front.next;
        }

        Node currO = head;
        Node currN = newHead;
        while (currO != null) {
            if (currO.random != null) {
                currN.random = nodeMap.get(currO.random);
            }
            currO = currO.next;
            currN = currN.next;
        }

        return newHead;
    }
}