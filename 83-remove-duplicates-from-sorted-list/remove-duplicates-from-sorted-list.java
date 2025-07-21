/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

// loot to traversr the until current  == null && current.next === null
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {//chek the vall cuurrent val and current,next equal 
                current.next = current.next.next;//remove the equal node 
            } else {
                current = current.next;//not same the move of next node
            }
        }
        return head;
    }
}