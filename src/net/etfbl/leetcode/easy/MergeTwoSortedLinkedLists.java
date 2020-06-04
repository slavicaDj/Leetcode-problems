package net.etfbl.leetcode.easy;

public class MergeTwoSortedLinkedLists {

	  private static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;

		if (l1 == null) {
			if (l2 == null)
				return null;
			head = l2;
			l2 = l2.next;
		}
		else if (l2 == null) {
			head = l1;
			l1 = l1.next;
		}
		else {
			if (l1. val <= l2.val) {
				head = l1;
				l1 = l1.next;
			}
			else {
				head = l2;
				l2 = l2.next;
			}
		}
		
		ListNode temp = head;
		
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				temp.next = l1;
				l1 = l1.next;
			}
			else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		
		if (l1 != null)
			temp.next = l1;
		
		if (l2 != null)
			temp.next = l2;
		
		return head;
    }
	
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(-9);
		ln1.next = new ListNode(3);
//		ln1.next.next = new ListNode(4);
		
		ListNode ln2 = new ListNode(5);
		ln2.next = new ListNode(7);
//		ln2.next.next = new ListNode(4);
		
		MergeTwoSortedLinkedLists mt = new MergeTwoSortedLinkedLists();
		ListNode head = mt.mergeTwoLists(ln1, ln2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		
	}
}
