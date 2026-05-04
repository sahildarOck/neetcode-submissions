/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private ListNode orphanNode;
    public ListNode reverseKGroup(ListNode head, int k) {
        // if(k != 5) {
        //     return null;
        // }
        ListNode prevNode = new ListNode(0);
        ListNode minusOneNode = prevNode;

        ListNode firstNode = head;
        ListNode lastNode;
        while(firstNode != null) {
            lastNode = reverseKNodes(firstNode, prevNode, 1, k);
            if(lastNode == null) {
                break;
            }
            lastNode.next = orphanNode;
            prevNode = lastNode;
            firstNode = orphanNode;
            // printList(prevNode.next);
        }

        return minusOneNode.next;
    }

    private ListNode reverseKNodes(ListNode head, ListNode prevNode, int n, int k) {
        if(head == null) {
            return null;
        }
        if(n == k) {
            orphanNode = head.next;
            prevNode.next = head;
            return head;
        }

        ListNode nextNode = reverseKNodes(head.next, prevNode, n + 1, k);
        if(nextNode == null) {
            return null;
        }
        nextNode.next = head;
        return head;
    }

    private void printList(ListNode head) {
        System.out.println();
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
