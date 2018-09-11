package com.linkedlist.sep10;

class OEListNode{
	
	int val;
	OEListNode next;
	public OEListNode(int val) {
		this.val = val;
	}
}

public class OddEvenLinkedList {

	public OEListNode oddEvenList(OEListNode head) {
		
		OEListNode final_list = head;
		OEListNode p1 = head;
		OEListNode p2 = head.next;
		OEListNode even_list = p2;
		
		while(p1 != null && even_list != null) {
			
			OEListNode t = even_list.next;
			if(t == null) {
				break;
			}
			
			p1.next = even_list.next;
			p1 = p1.next;
			even_list.next = p1.next;
			even_list = even_list.next;
			
		}
		
		p1.next = p2;
		return final_list;
		
	}
	
	public void printList(OEListNode head) {
		if(head == null) {
			return;
		}
		
		OEListNode nd = head;
		while(nd != null) {
			System.out.print(nd.val);
			if(nd.next != null) {
				System.out.print("->");
			}
			
			nd = nd.next;
		}
	}
	
	public static void main(String[] args) {
		
		OddEvenLinkedList ob = new OddEvenLinkedList();
		
		OEListNode n1 = new OEListNode(2);
		OEListNode n2 = new OEListNode(1);
		OEListNode n3 = new OEListNode(3);
		OEListNode n4 = new OEListNode(5);
		OEListNode n5 = new OEListNode(6);
		OEListNode n6 = new OEListNode(4);
		OEListNode n7 = new OEListNode(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		ob.printList(n1);
		System.out.println();
		OEListNode result = ob.oddEvenList(n1);
		ob.printList(result);
	}

}
