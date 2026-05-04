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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode valNode = new TreeNode(val);
        if(root == null) {
            return valNode;
        }

        TreeNode prev = root;
        TreeNode curr = root.val > val ? root.left : root.right;

        while(curr != null) {
            prev = curr;
            curr = curr.val > val ? curr.left : curr.right;
        }

        if(prev.val > val) {
            prev.left = valNode;
        } else {
            prev.right = valNode;
        }

        return root;
    }
}