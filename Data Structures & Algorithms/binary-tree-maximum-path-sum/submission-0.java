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
    int maxSum = -1001;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }

    private int pathSum(TreeNode root) {
        // max of (left, right, left + node, right + node, left + node + right)
        if(root == null) {
            return -1001;
        }
        int leftSum = pathSum(root.left);
        int rightSum = pathSum(root.right);
        int pathSum = root.val;

        maxSum = Math.max(maxSum, root.val);

        if(leftSum != -1001) {
            maxSum = Math.max(maxSum, leftSum);
            maxSum = Math.max(maxSum, root.val + leftSum);
        }
        if(rightSum != -1001) {
            maxSum = Math.max(maxSum, rightSum);
            maxSum = Math.max(maxSum, root.val + rightSum);
        }

        if(leftSum > 0 && rightSum > 0) {
            maxSum = Math.max(maxSum, leftSum + root.val + rightSum);
            pathSum += leftSum > rightSum ? leftSum : rightSum;
        } else if(leftSum > 0) {
            pathSum += leftSum;
        } else if(rightSum > 0) {
            pathSum += rightSum;
        }

        return pathSum;
    }
}
