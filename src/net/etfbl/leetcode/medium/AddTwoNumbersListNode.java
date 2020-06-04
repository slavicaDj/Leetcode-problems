package net.etfbl.leetcode.medium;

public class AddTwoNumbersListNode {
	
	public ListNode addTwoNumbers(ListNode ln1, ListNode ln2) {
		int sum = ln1.val + ln2.val;
		int carry = sum / 10;
		
		ListNode ln = new ListNode(sum % 10);
		ln1 = ln1.next;
		ln2 = ln2.next;
				
		ListNode temp = ln;
		while (true) {
			sum = carry;
			sum += (ln1 == null)? 0 : ln1.val;
			sum += (ln2 == null)? 0 : ln2.val;
			
			if (ln1 == null && ln2 == null && sum == 0)
				return ln;
			
			ListNode newListNode = new ListNode(sum % 10);
			temp.next = newListNode;
			temp = newListNode;
			
			if (ln1 == null && ln2 == null) {
				if (sum / 10 != 0) {
					ListNode newListNode2 = new ListNode(sum / 10);
					temp.next = newListNode2;
				}
				
				return ln;
			}

			carry = sum / 10;
			
			ln1 = (ln1 == null)? null : ln1.next;
			ln2 = (ln2 == null)? null : ln2.next;
		}
		
	}

	public static void main(String[] args) {
		//[9]
		//[1,9,9,9,9,9,9,9,9,9]
		
		ListNode ln0 = new ListNode(9);
		
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(9);
		ListNode ln3 = new ListNode(9);

		ln1.next = ln2;
		ln2.next = ln3;
		
		AddTwoNumbersListNode addTwo = new AddTwoNumbersListNode();
		ListNode sum = addTwo.addTwoNumbers(ln0, ln1);
		while(sum != null) {
			System.out.print(sum.val + " ");
			sum = sum.next;
		}
		
		System.out.println();

		//342
		ListNode ln11 = new ListNode(0);
		ListNode ln12 = new ListNode(0);
		ListNode ln13 = new ListNode(3);
		ln11.next = ln12;
		ln12.next = ln13;
		
		//465
		ListNode ln14 = new ListNode(0);
		ListNode ln15 = new ListNode(0);
		ListNode ln16 = new ListNode(9);
		ln14.next = ln15;
		ln15.next = ln16;
		
		ListNode sum1 = addTwo.addTwoNumbers(ln11, ln14);
		while(sum1 != null) {
			System.out.print(sum1.val + " ");
			sum1 = sum1.next;
		}
		
		System.out.println();
		
		ListNode ln00 = new ListNode(0);
		ListNode ln01 = new ListNode(0);
		ListNode sum0 = addTwo.addTwoNumbers(ln00, ln01);
		while(sum0 != null) {
			System.out.print(sum0.val + " ");
			sum0 = sum0.next;
		}
		
		System.out.println();

		//[9]
		//[1,9,9,9,9,9,8,9,9,9]
		ListNode ln30 = new ListNode(9);
		
		ListNode ln31 = new ListNode(1);
		ListNode ln32 = new ListNode(9);
		ListNode ln33 = new ListNode(9);
		ListNode ln34 = new ListNode(9);
		ListNode ln35 = new ListNode(9);
		ListNode ln36 = new ListNode(9);
		ListNode ln37 = new ListNode(8);
		ListNode ln38 = new ListNode(9);
		ListNode ln39 = new ListNode(9);
		ListNode ln310 = new ListNode(9);
		
		ln31.next = ln32;
		ln32.next = ln33;
		ln33.next = ln34;
		ln34.next = ln35;
		ln35.next = ln36;
		ln36.next = ln37;
		ln37.next = ln38;
		ln38.next = ln39;
		ln39.next = ln310;
		
		ListNode sum3 = addTwo.addTwoNumbers(ln30, ln31);
		while(sum3 != null) {
			System.out.print(sum3.val + " ");
			sum3 = sum3.next;
		}
		
	}
	
}