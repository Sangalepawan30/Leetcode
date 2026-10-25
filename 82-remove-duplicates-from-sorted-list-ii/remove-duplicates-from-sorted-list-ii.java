
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Check whether current value is duplicated
            if (curr.next != null && curr.val == curr.next.val) {

                // Skip all nodes with this duplicate value
                while (curr.next != null &&
                       curr.val == curr.next.val) {
                    curr = curr.next;
                }

                prev.next = curr.next;
            } else {
                // Keep this unique node
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
