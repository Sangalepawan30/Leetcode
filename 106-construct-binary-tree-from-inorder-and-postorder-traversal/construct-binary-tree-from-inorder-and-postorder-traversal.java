
class Solution {
    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        // Store inorder elements and their indexes
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode construct(int[] inorder, int[] postorder,
                              int left, int right) {

        // Base condition
        if (left > right) {
            return null;
        }

        // Last element of postorder is the root
        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int mid = map.get(rootValue);

        // Construct right subtree first
        root.right = construct(inorder, postorder, mid + 1, right);

        // Construct left subtree
        root.left = construct(inorder, postorder, left, mid - 1);

        return root;
    }
}
