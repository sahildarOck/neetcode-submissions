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
     List<List<Integer>> answer;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        answer = new ArrayList<>();
        answer.add(List.of(root.val));
        getLevelOrderList(Arrays.asList(Arrays.asList(root)));
        return answer;
    }

    private List<List<TreeNode>> getLevelOrderList(List<List<TreeNode>> levelOrderList) {
        if(levelOrderList.isEmpty()) {
            return levelOrderList;
        }
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        List<Integer> nextLevelNodesValues = new ArrayList<>();
        levelOrderList.get(levelOrderList.size() - 1).forEach(node -> {
            if(node.left != null) {
                nextLevelNodes.add(node.left);
                nextLevelNodesValues.add(node.left.val);
            }
            if(node.right != null) {
                nextLevelNodes.add(node.right);
                nextLevelNodesValues.add(node.right.val);
            }
        });
        if(nextLevelNodes.isEmpty()) {
            return levelOrderList;
        }
        List<List<TreeNode>> levelOrderListCopy = new ArrayList<>();
        levelOrderListCopy.addAll(levelOrderList);
        levelOrderListCopy.add(nextLevelNodes);

        answer.add(nextLevelNodesValues);
        return getLevelOrderList(levelOrderListCopy);
    }

    private List<List<Integer>> getValuesFromTreeNodes(List<List<TreeNode>> levelOrderList) {
        return (List<List<Integer>>) levelOrderList.stream()
                                .map(nodeList -> nodeList.stream()
                                                            .map(node -> node.val).collect(Collectors.toList())).collect(Collectors.toList());
    }
}
