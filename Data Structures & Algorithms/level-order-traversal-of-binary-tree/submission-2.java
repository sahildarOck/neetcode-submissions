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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levelOrderValues = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int qSize;
        while(!q.isEmpty()) {
            qSize = q.size();
            List<Integer> currentListValues = new ArrayList<>();
            for(int i = 0 ; i < qSize ; i++) {
                TreeNode removedNode = q.remove();
                currentListValues.add(removedNode.val);
                if(removedNode.left != null) {
                    q.add(removedNode.left);
                }
                if(removedNode.right != null) {
                    q.add(removedNode.right);
                }
            }
            levelOrderValues.add(currentListValues);
        }
        return levelOrderValues;
    }
}
