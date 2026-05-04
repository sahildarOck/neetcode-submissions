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
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = slow.next;
        ListNode front = l2.next;
        slow.next = null;
        l2.next = null;
        ListNode temp;
        while(front != null) {
            temp = front.next;
            front.next = l2;
            l2 = front;
            front = temp;
        }

        // merge front and head
        ListNode l1 = head;
        ListNode l1Next = head.next;
        ListNode l2Next = l2.next;

        while(l1 != null && l2 != null) {
            // System.out.println("Loopin here!");
            l1Next = l1.next;
            l1.next = l2;
            l1 = l1Next;

            l2Next = l2.next;
            l2.next = l1;
            l2 = l2Next;
        }
    }
}
