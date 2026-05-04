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

public class Codec {

    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder strBuilder = new StringBuilder();
        q.add(root);
        
        int size;
        TreeNode removedNode;
        while(!q.isEmpty()) {
            size = q.size();
            for(int i = 0 ; i < size ; i++) {
                removedNode = q.remove();
                if(removedNode == null) {
                    strBuilder.append("null");
                } else {
                    strBuilder.append(removedNode.val);
                    q.add(removedNode.left);
                    q.add(removedNode.right);
                }
                strBuilder.append(",");
            }
        }
        return strBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) {
            return null;
        }
        String[] nodes = data.split(",");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        
        int size;
        TreeNode removedNode;
        int nodesIndex = 1;
        TreeNode leftNode;
        TreeNode rightNode;
        while(nodesIndex < nodes.length) {
            removedNode = q.remove();
            if(removedNode == null) {
                continue;
            }
            if(nodes[nodesIndex].equals("null")) {
                leftNode = null;
            } else {
                leftNode = new TreeNode(Integer.parseInt(nodes[nodesIndex]));
            }
            nodesIndex++;

            if(nodes[nodesIndex].equals("null")) {
                rightNode = null;
            } else {
                rightNode = new TreeNode(Integer.parseInt(nodes[nodesIndex]));
            }
            nodesIndex++;

            removedNode.left = leftNode;
            removedNode.right = rightNode;
            q.add(leftNode);
            q.add(rightNode);
        }
        return root;
    }
}
