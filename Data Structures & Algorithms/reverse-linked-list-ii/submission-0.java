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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // beforeLeft.next = rightNode;
        // leftNode.next = afterRightNode;

        if(right == 1) {
            return head;
        }

        ListNode beforeLeftNode;
        ListNode leftNode;
        int index;
        if(left == 1) {
            beforeLeftNode = null;
            leftNode = head;
            index = 0;
        } else {
            beforeLeftNode = head;
            index = 1;
            while(index < left - 1) {
                beforeLeftNode = beforeLeftNode.next;
                index++;
            }
            leftNode = beforeLeftNode.next;
        }

        ListNode curr = leftNode;
        ListNode afterCurr = leftNode.next;
        ListNode temp;
        while(index < right - 1) {
            temp = afterCurr.next;
            afterCurr.next = curr;
            curr = afterCurr;
            afterCurr = temp;
            index++;
        }

        // System.out.println("beforeLeftNode: " + beforeLeftNode.val);
        // System.out.println("leftNode: " + leftNode.val);
        // System.out.println("curr: " + curr.val);
        // System.out.println("afterCurr: " + afterCurr.val);

        if(left != 1) {
            beforeLeftNode.next = curr;
        } else {
            head = curr;
        }
        leftNode.next = afterCurr;

        return head;
    }
}