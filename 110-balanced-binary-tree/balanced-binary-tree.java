
class Solution {

    public boolean isBalanced(TreeNode root) {

        return checkHeight(root) != -1;
    }

    public int checkHeight(TreeNode root) {

        // Base condition
        if (root == null) {
            return 0;
        }

        // Calculate left subtree height
        int left = checkHeight(root.left);

        if (left == -1) {
            return -1;
        }

        // Calculate right subtree height
        int right = checkHeight(root.right);

        if (right == -1) {
            return -1;
        }

        // Check height difference
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        // Return height
        return Math.max(left, right) + 1;
    }
}
