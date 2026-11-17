class Solution {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentNumber) {

        // If node is null
        if (node == null) {
            return 0;
        }

        // Build the number
        currentNumber = currentNumber * 10 + node.val;

        // If this is a leaf node
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        // Calculate left and right subtree sums
        return dfs(node.left, currentNumber)
             + dfs(node.right, currentNumber);
    }
}