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
   int preIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i < inorder.length ; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if(left > right) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex++]);
        int nodeIndex = inorderMap.get(node.val);

        node.left = buildTree(preorder, left, nodeIndex - 1);
        node.right = buildTree(preorder, nodeIndex + 1, right);

        return node;
    }
}
