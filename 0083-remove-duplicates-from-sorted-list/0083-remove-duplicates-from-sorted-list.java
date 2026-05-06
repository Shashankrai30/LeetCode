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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;

        while(temp!=null){
            ListNode tem=temp.next;
            while(tem!=null && tem.val==temp.val){
                tem=tem.next;
            }
            temp.next=tem;
            temp=tem;
        }

        return head;
    }
}