package com.linkedlist.sep10;

class MergeListNode{
	int val;
	MergeListNode next;
	MergeListNode(int val){
		this.val = val;
	}
}
public class MergeTwoSortedLists {
	
	public MergeListNode mergeTwoLists(MergeListNode l1, MergeListNode l2) {
		 
		MergeListNode slist1 = l1;
		MergeListNode slist2 = l2;
		
		MergeListNode mergelist = new MergeListNode(0);
		MergeListNode test = mergelist;
		
		while(slist1 != null && slist2 != null) {
			
			if(slist1.val <= slist2.val) {
				test.next = slist1;
				slist1 = slist1.next;
			}else {
				test.next = slist2;
				slist2 = slist2.next;
			}
			
			test = test.next;
		}
		
		while(slist1 != null) {
			test.next = slist1;
			slist1 = slist1.next;
			test = test.next;
		}
		
		while(slist2 != null) {
			test.next = slist2;
			slist2 = slist2.next;
			test = test.next;
		}
		
		return mergelist.next;
		
    }
	
	public void printList(MergeListNode head) {
		
		if(head == null) {
			return;
		}
		
		MergeListNode nd = head;
		
		while(nd != null) {
			System.out.print(nd.val);
			
			if(nd.next != null) {
				System.out.print("->");
			}
			
			nd = nd.next;
			
		}
	}

	public static void main(String[] args) {
		
		MergeTwoSortedLists ob = new MergeTwoSortedLists();
		
		MergeListNode n1 = new MergeListNode(3);
		MergeListNode n2 = new MergeListNode(5);
		MergeListNode n3 = new MergeListNode(6);
		MergeListNode n4 = new MergeListNode(8);
		MergeListNode n5 = new MergeListNode(10);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		MergeListNode node1 = new MergeListNode(1);
		MergeListNode node2 = new MergeListNode(4);
		MergeListNode node3 = new MergeListNode(5);
		MergeListNode node4 = new MergeListNode(12);
		MergeListNode node5 = new MergeListNode(15);
		MergeListNode node6 = new MergeListNode(18);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		
		MergeListNode result = ob.mergeTwoLists(n1, node1);
		
		ob.printList(result);

	}

}
