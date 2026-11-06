class Solution {
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node leftmost = root;

        while (leftmost.left != null) {

            Node current = leftmost;

            while (current != null) {

                // Connect left child to right child
                current.left.next = current.right;

                // Connect right child to next parent's left child
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }

            leftmost = leftmost.left;
        }

        return root;
    }
}
        
    
