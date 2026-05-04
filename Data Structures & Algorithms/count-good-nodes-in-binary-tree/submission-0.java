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
    public int goodNodes(TreeNode root) {
        return goodNodes(root.left, root.val, 0) + goodNodes(root.right, root.val, 0) + 1;
    }

    private int goodNodes(TreeNode root, int max, int goodNodesCount) {
        if(root == null) {
            return goodNodesCount;
        }
        if(root.val >= max) {
            max = root.val;
            goodNodesCount++;
        }
        return goodNodes(root.left, max, 0) + goodNodes(root.right, max, 0) + goodNodesCount;
    }
}
