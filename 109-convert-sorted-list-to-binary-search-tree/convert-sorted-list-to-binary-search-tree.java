
class Solution {

    public TreeNode sortedListToBST(ListNode head) {

        // Base condition
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // Find middle node
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half
        prev.next = null;

        // Middle node becomes root
        TreeNode root = new TreeNode(slow.val);

        // Construct left subtree
        root.left = sortedListToBST(head);

        // Construct right subtree
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
