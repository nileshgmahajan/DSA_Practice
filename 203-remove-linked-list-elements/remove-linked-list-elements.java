/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
       //Create the dummy  Node point the head
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode current=dummy;


    //Traverse and remove the Node 
        while(current.next != null)
        {
            if(current.next.val == val)
            {
                current.next=current.next.next;//skip the node
            }else
            {
                // movd the forward
                current=current.next;
            }
        }

//return the newNode
        return dummy.next;
    }
}