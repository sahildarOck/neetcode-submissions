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
    private int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);

        return maxDiameter;
    }

    private int getMaxDepth(TreeNode node) {
        if(node == null) {
            return -1;
        }

        int maxLeftDepth = getMaxDepth(node.left) + 1;
        int maxRightDepth = getMaxDepth(node.right) + 1;

        int diameter = maxLeftDepth + maxRightDepth;
        if(diameter > maxDiameter) {
            maxDiameter = diameter;
        }

        return maxLeftDepth > maxRightDepth ? maxLeftDepth : maxRightDepth;
    }
}
