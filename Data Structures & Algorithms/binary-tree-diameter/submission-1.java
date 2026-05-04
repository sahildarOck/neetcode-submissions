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
        int[] maxDiameter = new int[1];
        getMaxDepth(root, maxDiameter);

        return maxDiameter[0];
    }

    private int getMaxDepth(TreeNode node, int[] maxDiameter) {
        if(node == null) {
            return -1;
        }

        int maxLeftDepth = getMaxDepth(node.left, maxDiameter) + 1;
        int maxRightDepth = getMaxDepth(node.right, maxDiameter) + 1;

        maxDiameter[0] = Math.max(maxDiameter[0], maxLeftDepth + maxRightDepth);

        return maxLeftDepth > maxRightDepth ? maxLeftDepth : maxRightDepth;
    }
}
