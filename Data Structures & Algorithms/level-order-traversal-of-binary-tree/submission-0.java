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
        return getValuesFromTreeNodes(getLevelOrderList(Arrays.asList(Arrays.asList(root))));
    }

    private List<List<TreeNode>> getLevelOrderList(List<List<TreeNode>> levelOrderList) {
        if(levelOrderList.isEmpty()) {
            return levelOrderList;
        }
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        levelOrderList.get(levelOrderList.size() - 1).forEach(node -> {
            if(node.left != null) {
                nextLevelNodes.add(node.left);
            }
            if(node.right != null) {
                nextLevelNodes.add(node.right);
            }
        });
        if(nextLevelNodes.isEmpty()) {
            return levelOrderList;
        }
        List<List<TreeNode>> levelOrderListCopy = new ArrayList<>();
        levelOrderListCopy.addAll(levelOrderList);
        levelOrderListCopy.add(nextLevelNodes);
        return getLevelOrderList(levelOrderListCopy);
    }

    private List<List<Integer>> getValuesFromTreeNodes(List<List<TreeNode>> levelOrderList) {
        return (List<List<Integer>>) levelOrderList.stream()
                                .map(nodeList -> nodeList.stream()
                                                            .map(node -> node.val).collect(Collectors.toList())).collect(Collectors.toList());
    }
}
