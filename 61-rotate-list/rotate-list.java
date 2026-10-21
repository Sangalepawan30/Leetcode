class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length and the last node
        ListNode tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Remove unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Connect the last node to the first node
        tail.next = head;

        // Find the new tail
        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Set the new head and break the circular list
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}