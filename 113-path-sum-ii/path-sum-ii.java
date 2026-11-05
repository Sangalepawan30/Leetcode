class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path);

        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path) {

        if (node == null) {
            return;
        }

        // Add current node to path
        path.add(node.val);

        // Check if leaf node and target sum is reached
        if (node.left == null && node.right == null
                && targetSum == node.val) {

            result.add(new ArrayList<>(path));

        } else {
            dfs(node.left, targetSum - node.val, path);
            dfs(node.right, targetSum - node.val, path);
        }

        // Backtracking
        path.remove(path.size() - 1);
    }
}