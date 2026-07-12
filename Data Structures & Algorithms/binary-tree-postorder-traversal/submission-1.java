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
    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;
        while(current != null || !st.isEmpty()) {
            while(current != null) {
                st.push(current);
                current = current.left;
            }

            TreeNode peekNode = st.peek();
            if(peekNode.right != null && prev != peekNode.right) {
                current = peekNode.right;
            } else {
                ans.add(peekNode.val);
                prev = st.pop();
            }
        }

        return ans;
    }
}