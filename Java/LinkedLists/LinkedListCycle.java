//LinkedListCycle
package com.linkedlist.sep7;

class ListNode1{
	
	int val;
	ListNode1 next;
	ListNode1(int val){
		this.val = val;
	}
}

public class LinkedListCycle {
	
	public static boolean hasCycle(ListNode1 head) {
        
		if(head == null || head.next == null) {
			return false;
		}
		
		ListNode1 slow_ptr = head;
		ListNode1 fast_ptr = head;
		
		while(fast_ptr != null && fast_ptr.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
			
			if(fast_ptr == slow_ptr) {
				return true;
			}
		}
		
		return false;
    }

	public static void main(String[] args) {
		
		ListNode1 l1 = new ListNode1(10);
		ListNode1 l2 = new ListNode1(20);
		ListNode1 l3 = new ListNode1(30);
		ListNode1 l4 = new ListNode1(40);
		ListNode1 l5 = new ListNode1(50);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l1;
		
		if(hasCycle(l1)) {
			System.out.println("Has Cycle!!");
		}else {
			System.out.println("Does not contain Cycle!!");
		}
		
	}

}
