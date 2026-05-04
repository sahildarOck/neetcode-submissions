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
         // System.out.println("getNumberAsString(l1): " + getNumberAsString(l1));
        // System.out.println("getNumberAsString(l2): " + getNumberAsString(l2));
        char[] l1CharArr = getNumberAsString(l1).toCharArray();
        char[] l2CharArr = getNumberAsString(l2).toCharArray();

        int l1Index = 0;
        int l2Index = 0;
        boolean carry = false;
        ListNode prevNode = null;
        ListNode ans = null;
        while(l1Index < l1CharArr.length && l2Index < l2CharArr.length) {
            int sum = Integer.parseInt(String.valueOf(l1CharArr[l1Index++])) + Integer.parseInt(String.valueOf(l2CharArr[l2Index++]));
            if(carry) {
                sum += 1;
            }
            ListNode newNode = new ListNode();

            if(sum > 9) {
                carry = true;
                newNode.val = sum % 10;
            } else {
                carry = false;
                newNode.val = sum;
            }

            if(prevNode == null) {
                ans = newNode;
            } else {
                prevNode.next = newNode;
            }
            prevNode = newNode;
        }

        while(l1Index < l1CharArr.length) {
            // System.out.println("l1CharArr[l1Index]: " + l1CharArr[l1Index]);
            int val = Integer.parseInt(String.valueOf(l1CharArr[l1Index++]));
            if(carry) {
                val += 1;
                carry = false;
            }
            ListNode newNode = new ListNode();
            if(val > 9) {
                carry = true;
                newNode.val = val % 10;
            } else {
                carry = false;
                newNode.val = val;
            }
            if(prevNode != null) {
                prevNode.next = newNode;
            }
            prevNode = newNode;
        }

        while(l2Index < l2CharArr.length) {
            // System.out.println("l2CharArr[l2Index]: " + l2CharArr[l2Index]);
            int val = Integer.parseInt(String.valueOf(l2CharArr[l2Index++]));
            if(carry) {
                val += 1;
            }
            ListNode newNode = new ListNode();
            if(val > 9) {
                carry = true;
                newNode.val = val % 10;
            } else {
                carry = false;
                newNode.val = val;
            }
            if(prevNode != null) {
                prevNode.next = newNode;
            }
             prevNode = newNode;
        }

        if(carry) {
            ListNode newNode = new ListNode(1);
            prevNode.next = newNode;
        }
        return ans;
     }

    private String getNumberAsString(ListNode l1) {
        StringBuilder strBuilder = new StringBuilder();
        while(l1 != null) {
            strBuilder.append(l1.val);
            l1 = l1.next;
        }
        return strBuilder.toString();
    }
}
