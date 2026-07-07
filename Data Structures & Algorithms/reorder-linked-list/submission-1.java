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
        // reverse the 2nd half
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverseLinkedList(slow);
        ListNode first = head;
        ListNode firstNext;
        ListNode secondNext;

        while(first != null && second != null && first.next != second) {
            firstNext = first.next;
            secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode reverseLinkedList(ListNode start) {
        if(start == null || start.next == null) {
            return start;
        }
        ListNode front = start.next;
        ListNode rear = start;
        rear.next = null;

        ListNode temp;
        while(front != null) {
            temp = front.next;
            front.next = rear;
            rear = front;
            front = temp;
        }
        return rear;
    }
}