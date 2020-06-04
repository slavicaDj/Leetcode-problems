package net.etfbl.leetcode.medium;
public class AddTwoNumbersInt {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int number1 = listNodeToInt(l1);
        int number2 = listNodeToInt(l2);
        
        int sum = number1 + number2; //123
        
        ListNode sumNode = new ListNode(sum % 10);
        sum /= 10;

        ListNode temp = sumNode;
        while (sum != 0) {
        	ListNode newNode = new ListNode(sum % 10);
        	temp.next = newNode;
        	temp = newNode;
        	sum /= 10;
        }
        
        return sumNode;
    }
	
	private int listNodeToInt(ListNode ln) {
		int number = 0;

		for (int counter = 1; ln != null; ln = ln.next, counter *= 10)
			number = number + ln.val * counter;
		
		return number;
	}
	
	public static void main(String[] args) {
		//[9]
		//[1,9,9,9,9,9,9,9,9,9]

		ListNode ln1 = new ListNode(2);
		ListNode ln2 = new ListNode(4);
		ListNode ln3 = new ListNode(3);
		ln1.next = ln2;
		ln2.next = ln3;
		
		ListNode ln4 = new ListNode(5);
		ListNode ln5 = new ListNode(6);
		ListNode ln6 = new ListNode(4);
		ln4.next = ln5;
		ln5.next = ln6;
		
		AddTwoNumbersInt addTwo = new AddTwoNumbersInt();
		ListNode sum = addTwo.addTwoNumbers(ln1, ln4);
		System.out.println(addTwo.listNodeToInt(ln1));
		System.out.println(addTwo.listNodeToInt(ln4));
		System.out.println(addTwo.listNodeToInt(sum));
		
	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
