/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int traversedCount = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return - 1;
        }
        int leftValue = kthSmallest(root.left, k);
        if(leftValue != -1) {
            return leftValue;
        }
        traversedCount++;
        if(traversedCount == k) {
            return root.val;
        }
        int rightValue = kthSmallest(root.right, k);
        return rightValue;
    }
}
