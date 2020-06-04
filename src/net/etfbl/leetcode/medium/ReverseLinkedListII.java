package net.etfbl.leetcode.medium;

import java.util.Stack;

public class ReverseLinkedListII {
	 
	    public ListNode reverseBetween(ListNode head, int m, int n) {

	        // Empty list
	        if (head == null) {
	            return null;
	        }

	        // Move the two pointers until they reach the proper starting point
	        // in the list.
	        ListNode cur = head, prev = null;
	        while (m > 1) {
	            prev = cur;
	            cur = cur.next;
	            m--;
	            n--;
	        }

	        // The two pointers that will fix the final connections.
	        ListNode con = prev, tail = cur;

	        // Iteratively reverse the nodes until n becomes 0.
	        ListNode third = null;
	        while (n > 0) {
	            third = cur.next;
	            cur.next = prev;
	            prev = cur;
	            cur = third;
	            n--;
	        }

	        // Adjust the final connections as explained in the algorithm
	        if (con != null) {
	            con.next = prev;
	        } else {
	            head = prev;
	        }

	        tail.next = cur;

	        return head;
	    }
	
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ListNode ln5 = new ListNode(5);
		ListNode ln6 = new ListNode(6);
//		ListNode ln7 = new ListNode(7);
//		ListNode ln8 = new ListNode(8);

		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = ln6;
//		ln6.next = ln7;
//		ln7.next = ln8;
		
		ReverseLinkedListII rll = new ReverseLinkedListII();
		ListNode result = rll.reverseBetween(ln1, 3, 5);
		
		while (result != null) {
			System.out.println(result);
			result = result.next;
		}
	}

	// Definition for singly-linked list.
	private static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	    
	    public String toString() {
	    	return "value: " + val + ", next: " + ((next == null)? null : next.val);
	    }
	}
}


