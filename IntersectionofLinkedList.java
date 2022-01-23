//Leetcode: Easy
//TC: O(N)
//SC: O(1);
//As returning the value of the memory address of the linkedList which then gives out that the linked list is starting to intersect from this memory address
//Return memory address of headA only

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
        if(headA==null || headB==null) return null; 
        
        int lenA=0;
        ListNode curr=headA;
        while(curr!=null){
            curr=curr.next;
            lenA++;
        }
        int lenB=0;
        curr=headB;
        while(curr!=null){
            curr=curr.next;
            lenB++;
        }
        while(lenA>lenB){
            headA=headA.next;;
            lenA--;
        }
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        //Must not check if the lInkedList has inersected or not;
        //as if keepong the condition, the intersection of null will never arrise;
        //&& headA.next!=null && headB.next!=null
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
