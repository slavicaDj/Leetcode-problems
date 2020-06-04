package net.etfbl.leetcode.medium;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedListsPQ {

	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>();
		

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}
		
		ListNode head = new ListNode(0);
		ListNode tail = head;

		while(!pq.isEmpty()) {
			tail.next = pq.poll();
			tail = tail.next;
			/* tail is smallest element, now we add its successor to pq */
			ListNode nextNode = tail.next;
			if (nextNode != null)
				pq.add(nextNode);
		}
		
		return head.next;
	}
	
	public static void main(String[] args) {
		/*
		 	1->4->5,
  			1->3->4,
  			2->6
		 */
		
		ListNode ln1 = new ListNode(-1);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(5);
		
		ListNode ln2 = new ListNode(1);
		ln2.next = new ListNode(3);
		ln2.next.next = new ListNode(4);
		
		ListNode ln3 = new ListNode(2);
		ln3.next = new ListNode(6);
		
		ListNode[] lists = new ListNode[]{ln2, ln1, ln3};
		System.out.println("solution: " + mergeKLists(lists));
		
	}
	
	public static class ListNode implements Comparable<ListNode> {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	      
	      public String toString() {
	    	  return "" + val;
	      }

		@Override
		public int compareTo(ListNode o2) {
			if (this == o2)
				return 0;
			if (this.val < o2.val)
				return -1;
			else if (this.val > o2.val)
				return 1;
			else
				return 0;
		}
	}
}
