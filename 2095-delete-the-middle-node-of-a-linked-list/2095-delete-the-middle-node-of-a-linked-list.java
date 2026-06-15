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
    public ListNode deleteMiddle(ListNode head) {

        if(head==null || head.next==null) return null;

        int n=0;
        ListNode temp=head;

        while(temp!=null){
            n++;
            temp=temp.next;
        }

        int count=1;

        ListNode head1=head;

        while(count<(n)/2){
            head1=head1.next;
            count++;
        }

        head1.next=head1.next.next;

        return head;
    }
}