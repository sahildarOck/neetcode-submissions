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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        int currSum = l1Curr.val + l2Curr.val;
        int carry = 0;
        if (currSum > 9) {
            carry = 1;
            currSum = currSum % 10;
        }
        ListNode l3 = new ListNode(currSum);
        ListNode l3Curr = l3;
        l1Curr = l1.next;
        l2Curr = l2.next;
        while (l1Curr != null && l2Curr != null) {
            currSum = l1Curr.val + l2Curr.val;
            currSum += carry;
            if (currSum > 9) {
                carry = 1;
                currSum = currSum % 10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(currSum);
            l3Curr.next = newNode;
            l3Curr = l3Curr.next;
            l1Curr = l1Curr.next;
            l2Curr = l2Curr.next;
        }

        while (l1Curr != null) {
            if (l1Curr.val == 9 && carry == 1) {
                currSum = 0;
                carry = 1;
            } else {
                currSum = l1Curr.val + carry;
                carry = 0;
            }
            ListNode newNode = new ListNode(currSum);
            l3Curr.next = newNode;
            l3Curr = l3Curr.next;
            l1Curr = l1Curr.next;
        }

        while (l2Curr != null) {
            if (l2Curr.val == 9 && carry == 1) {
                currSum = 0;
                carry = 1;
            } else {
                currSum = l2Curr.val + carry;
                carry = 0;
            }
            ListNode newNode = new ListNode(currSum);
            l3Curr.next = newNode;
            l3Curr = l3Curr.next;
            l2Curr = l2Curr.next;
        }

        if(carry == 1) {
            ListNode newNode = new ListNode(1);
            l3Curr.next = newNode;
        }

        return l3;
    }
}