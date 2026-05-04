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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode front = head.next;
        ListNode rear = head;
        ListNode temp;
        while(front != null) {
            temp = front.next;
            front.next = rear;
            rear = front;
            front = temp;
        }

        head.next = null;
        head = rear;

        return head;
    }
}
