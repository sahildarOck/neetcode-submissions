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
        int backtrackCount = removeNthFromEndWithRecursion(head.next, head, n);
        if(backtrackCount == n - 1) {
            ListNode ans = head.next;
            head.next = null;
            return ans;
        }
        return head;
    }

    private int removeNthFromEndWithRecursion(ListNode front, ListNode rear, int n) {
        if(front == null) {
            return 0;
        }
        int backtrackCount = removeNthFromEndWithRecursion(front.next, front, n) + 1;
        if(backtrackCount == n) {
            rear.next = front.next;
            front.next = null;
        }
        return backtrackCount;
    }
}
