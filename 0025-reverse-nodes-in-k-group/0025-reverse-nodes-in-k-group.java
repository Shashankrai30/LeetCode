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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size=size(head);
        return helper(head,k,size);
    }

    int size(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }

        return count;
    }

    ListNode helper(ListNode head,int k,int size){
        if(size<k || head==null) return head;

        ListNode dummy=null;
        ListNode tail=head;
        int i=1;

        while(head!=null && i++<=k){
            size--;
            ListNode temp=head.next;
            head.next=dummy;
            dummy=head;
            head=temp;
        }

        tail.next=helper(head,k,size);

        return dummy;
    }
}