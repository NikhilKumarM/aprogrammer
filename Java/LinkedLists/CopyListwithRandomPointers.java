package com.linkedlist.sep10;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};
 
public class CopyListwithRandomPointers {
	
	public RandomListNode copyRandomList(RandomListNode head) {
	
		if(head == null) {
			return null;
		}
		//create a copy of the current linkedlist
		RandomListNode node = head;
		while(node != null) {
			RandomListNode nd = new RandomListNode(node.label);
			nd.next = node.next;
			node.next = nd;
			node = nd.next;
		}
        
		//copy the random pointer
		RandomListNode curr = head;
		while(curr != null) {
			if(curr.random != null) {
				curr.next.random = curr.random.next;
			}
			
			curr = curr.next.next;
		}
		
		//remove the newly created list 
		RandomListNode p1 = head;
		RandomListNode p2 = head.next;
		
		while(p1 != null) {
			RandomListNode temp = p1.next;
			p1.next = temp.next;
			
			if(temp.next != null) {
				temp.next = temp.next.next;
			}
			p1 = p1.next;
		}
		
		return p2;
		
		
    }
	

	public static void main(String[] args) {
		
		RandomListNode l1 = new RandomListNode(10);
		RandomListNode l2 = new RandomListNode(20);
		RandomListNode l3 = new RandomListNode(30);
		RandomListNode l4 = new RandomListNode(40);
		RandomListNode l5 = new RandomListNode(50);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		l1.random = l3;
		l2.random = l5;
		l3.random = l1;
		l4.random = l2;
		l5.random = l1;
	}

}
