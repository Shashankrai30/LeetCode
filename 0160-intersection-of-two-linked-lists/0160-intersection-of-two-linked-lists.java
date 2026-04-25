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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int asize=size(headA);
        int bsize=size(headB);

        if(asize>bsize){
            for(int i=0;i<asize-bsize;i++){
                headA=headA.next;
            }
        }
        else{
            for(int i=0;i<bsize-asize;i++){
                headB=headB.next;
            }
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }

        return headA;
    }

    int size(ListNode head){
        int size=0;

        while(head!=null){
            size++;
            head=head.next;
        }

        return size;
    }
}