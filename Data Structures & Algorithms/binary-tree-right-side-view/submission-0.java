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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return List.of();
        }

        List<Integer> rightViewNodes = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int qSize;
        while(!q.isEmpty()) {
            qSize = q.size();
            TreeNode removedNode;
            for(int i = 0 ; i < qSize ; i++) {
                removedNode = q.remove();
                if(removedNode.left != null) {
                    q.add(removedNode.left);
                }
                if(removedNode.right != null) {
                    q.add(removedNode.right);
                }
                if(i == qSize - 1) {
                    rightViewNodes.add(removedNode.val);
                }
            }
        }

        return rightViewNodes;
    }
}
