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
    public boolean isBalanced(TreeNode root) {
        int[] leftRightDepthDifference = new int[1];
        getMaxDepth(root, leftRightDepthDifference);

        return leftRightDepthDifference[0] < 2;
    }

    private int getMaxDepth(TreeNode node, int[] leftRightDepthDifference) {
        if(node == null || leftRightDepthDifference[0] > 1) {
            return -1;
        }
        int leftDepth = getMaxDepth(node.left, leftRightDepthDifference) + 1;
        int rightDepth = getMaxDepth(node.right, leftRightDepthDifference) + 1;
        leftRightDepthDifference[0] = Math.max(leftRightDepthDifference[0], Math.abs(leftDepth - rightDepth));

        return Math.max(leftDepth, rightDepth);
    }
}
