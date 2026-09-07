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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode list1Index = list1;
        ListNode list2Index = list2;
        while(list1Index != null && list2Index != null) {
            if(list1Index.val > list2Index.val) {
                curr.next = list2Index;
                list2Index = list2Index.next;
            } else {
                curr.next = list1Index;
                list1Index = list1Index.next;
            }
            curr = curr.next;
        }
        if(list1Index != null) {
            curr.next = list1Index;
        }

        if(list2Index != null) {
            curr.next = list2Index;
        }

        return dummy.next;
    }
}