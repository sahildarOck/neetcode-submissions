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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode curr;
        while(!st.isEmpty()) {
            curr = st.pop();
            list.add(curr.val);
            if(curr.right != null) {
                st.add(curr.right);
            }
            if(curr.left != null) {
                st.add(curr.left);
            }
        }
        return list;
    }
}