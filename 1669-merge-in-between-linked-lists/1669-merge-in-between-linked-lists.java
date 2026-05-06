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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp=list1;
        ListNode Next=list1.next;

        for(int i=1;i<a;i++){
            temp=temp.next;
            Next=Next.next;
        }

        temp.next=list2;

        while(list2.next!=null){
            list2=list2.next;
        }

        for(int i=a;i<=b;i++){
            Next=Next.next;
        }

        list2.next=Next;

        return list1;
    }
}