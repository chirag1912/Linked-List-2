//TC: O(n/2) for finding mid +O(n/2) for reversing the linked list + O(n) for giving the list in the given sequence;
//SC: O(1) for since only using variable pointers to travel the linkedlist;

class Solution {
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null){
            return;
        }
        
        //find the mid firstly then move to sparate the list and revrse it using the function of reverse();
        ListNode slow=head;
        ListNode fast=slow.next;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // System.out.println(slow.next.val);
        
        //Reverse the Linked List starting from slow.next elemment;
        fast=reverse(slow.next);
        slow.next=null;
        //MERGE THEM TOGETHER:
        slow=head;
        ListNode dummy=slow.next;
        while(fast!=null){
            slow.next=fast;
            slow=fast;
            fast=fast.next;
            slow.next=dummy;
            slow=dummy;
            
            if(dummy!=null){
                dummy=dummy.next;
            }    
        }
        // return head; 
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        // System.out.println(curr.next);
        ListNode fast=curr.next;
        
        while(fast!=null){
           curr.next=prev;  //assign
            prev=curr;      //shifing all next for end condition they will be shifted one position;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}
