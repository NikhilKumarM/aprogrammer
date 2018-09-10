//Reordering LinkedList
package com.linkedlist.sep7;

class ListNode{
	
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}

public class ReorderList {
	
	public static void reorderList(ListNode head) {
		
		if(head == null || head.next == null) {
			return;
		}
		
		ListNode slow_ptr = head;
		ListNode fast_ptr = head;
		
		
		while(fast_ptr != null && fast_ptr.next != null && fast_ptr.next.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		
		ListNode second_list = slow_ptr.next;
		slow_ptr.next = null;
		
		ListNode fl = head;
		second_list = reverseList(second_list);
		ListNode sl = second_list;
		
		while(sl != null) {
			
			ListNode p1 = fl.next;
			ListNode p2 = sl.next;
			
			fl.next = sl;
			sl.next = p1;
			
			fl = p1;
			sl = p2;
		}
		
		printList(head);
	}
	
	public static ListNode reverseList(ListNode head) {
		
		ListNode curr = head;
		ListNode prev = null;
		ListNode later = curr.next; 
		
		while(curr != null) {
			curr.next = prev;
			prev = curr;
			curr = later;
			
			if(curr != null) {
				later = curr.next;
			}
			
		}
		
		head = prev;
		return head;
	}
	
	public static void printList(ListNode head) {
		
		ListNode ln = head;
		while(ln != null) {
			System.out.print(ln.val);
			ln = ln.next;
			if(ln != null) {
				System.out.print("->");
			}
		}
	}
	

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(10);
		ListNode l2 = new ListNode(20);
		ListNode l3 = new ListNode(30);
		ListNode l4 = new ListNode(40);
		ListNode l5 = new ListNode(50);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		System.out.println("Initial List:");
		
		printList(l1);
		System.out.println();
		
		System.out.println("Reordered List: ");
		reorderList(l1);
		

	}

}
