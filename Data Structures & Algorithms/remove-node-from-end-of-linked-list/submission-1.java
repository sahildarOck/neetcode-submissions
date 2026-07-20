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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;

        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int posToRemove = length - n + 1;
        if (posToRemove == 1) {
            head = head.next;
            return head;
        }

        ListNode rear = head;
        ListNode front = rear.next;
        for (int i = 1; i < posToRemove - 1; i++) {
            front = front.next;
            rear = rear.next;
        }
        rear.next = front.next;
        front.next = null;
        return head;
    }
}