package net.etfbl.leetcode.medium;

public class RemoveDuplicatesFromSortedListII {
	
	  private static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 

	// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	// Return the linked list sorted as well.
    public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;

        ListNode prev = null, curr = head;
		
		while (curr != null) {
			ListNode third = curr.next;
			int count = 0;
			
			while (third != null) {
				if (curr.val != third.val)
					break;
				third = third.next;
				count++;
			}
			
			if (count == 0) {
				prev = curr;
				curr = curr.next;
				continue;
			}
			
			if (prev == null) {
				head = third;
				curr = third;
				continue;
			}
				
			prev.next = third;
			curr = third;			
		}
		
		return head;
    }
    
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(1);
		ListNode ln3 = new ListNode(2);
		ListNode ln4 = new ListNode(2);
//		ListNode ln5 = new ListNode(3);
//		ListNode ln6 = new ListNode(3);
//		ListNode ln6 = new ListNode(5);
//		ListNode ln7 = new ListNode(7);
//		ListNode ln8 = new ListNode(8);

		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
//		ln4.next = ln5;
//		ln5.next = ln6;
//		ln6.next = ln7;
//		ln7.next = ln8;
		
		RemoveDuplicatesFromSortedListII rd = new RemoveDuplicatesFromSortedListII();
		ListNode result = rd.deleteDuplicates(ln1);
		
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
