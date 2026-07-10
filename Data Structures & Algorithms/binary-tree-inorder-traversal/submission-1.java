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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        TreeNode pointer = root;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            if(pointer.left != null) {
                st.push(pointer.left);
                pointer = pointer.left;
            } else {
                TreeNode curr = st.pop();
                list.add(curr.val);
                if(curr.right != null) {
                    st.push(curr.right);
                    pointer = curr.right;
                }
            }
        }

        return list;
    }
}