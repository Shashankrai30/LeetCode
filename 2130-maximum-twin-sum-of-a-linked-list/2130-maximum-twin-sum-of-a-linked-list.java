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
    public int pairSum(ListNode head) {
        int size=0;
        ListNode s=head;

        while(s!=null){
            size++;
            s=s.next;
        }

        ListNode temp=head;
        int n=1;

        while(n<size/2){
            temp=temp.next;
            n++;
        }

        temp.next=reverse(temp.next);

        ListNode head2=temp.next;

        int max=Integer.MIN_VALUE;

        while(head2!=null){
            int sum=head.val+head2.val;
            max=Math.max(sum,max);
            head=head.next;
            head2=head2.next;
        }

        return max;
    }

    ListNode reverse(ListNode head){
        ListNode temp=null;
        ListNode dummy=head;

        while(dummy!=null){
            ListNode nex=dummy.next;
            dummy.next=temp;
            temp=dummy;
            dummy=nex;
        }

        return temp;
    }
}