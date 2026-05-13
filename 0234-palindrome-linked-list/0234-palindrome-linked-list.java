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
    public boolean isPalindrome(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        ListNode curr=head;
        while(curr!=null){
            ListNode t=new ListNode(curr.val);
            temp.next=t;
            curr=curr.next;
            temp=temp.next;
        }

        ListNode Head=reverse(dummy.next);

        while(head!=null && Head!=null){
            if(head.val!=Head.val) return false;

            head=head.next;
            Head=Head.next;
        }

        return true;
    }

    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }
}