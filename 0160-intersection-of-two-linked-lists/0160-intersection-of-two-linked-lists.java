/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int size1=size(head1);
        int size2=size(head2);
        
        if(size1>size2){
            int i = 1;
            while(i<=size1-size2){
                head1=head1.next;
                i++;
            }
        }
        
        if(size1<size2){
            int i = 1;
            while(i<=size2-size1){
                head2=head2.next;
                i++;
            }
        }
        
        while(head1!=null && head2!=null){
            if(head1==head2){
                return head1;
            }
            head1=head1.next;
            head2=head2.next;
        }
        
        return null;
    }
    
    int size(ListNode head){
        int i=0;
        while(head!=null){
            i++;
            head=head.next;
        }
        
        return i;
    }
}