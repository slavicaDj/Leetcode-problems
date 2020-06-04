package net.etfbl.leetcode.medium;
import java.util.HashMap;

public class LRUCache {

	/* least recently used */
	private Node head;
	/* most recently used */
	private Node tail;
	private HashMap<Integer, Node> map;
	private int capacity;

    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	map = new HashMap<>();
    }
    
    public int get(int key) {
    	/* return key and increase its rank */
    	Node node = map.get(key);
    	
    	if (node == null)
    		return -1;
    	
    	if (node == tail)
    		return node.value;
    	
    	insertAtTail(node.key, node.value);
        
    	return tail.value;
    }
    
    public void put(int key, int value) {
    	if (map.size() + 1 > capacity) {
    		map.remove(head.key);
    		head = head.next;
    		insertAtTail(key, value);
    	}
    	else {
    		if (map.size() == 0) {
    			Node node = new Node(key, value);
    			head = node;
    			tail = node;
    			map.put(key, node);
    		}
    		else
    			insertAtTail(key, value);
    	}
    }
    
    public void insertAtTail(int key, int value) {
		Node node = map.get(key);
		if (node == null) {
			node = new Node(key, value);
			map.put(key, node);
		}
		
		if (map.size() == 1) {
			/* separate head and tail */
			tail = node;
			tail.previous = head;
			tail.next = null;
			
			head.next = tail;
		}
		else {
			if (node == head) {
				head = head.next;
				head.previous = null;

				Node temp = tail;
				temp.next = node;

				tail = node;
				tail.previous = temp;
				tail.next = null;
				tail.value = value;
			}
			else if (node == tail)
				tail.value = value;
			else {
		    	Node temp = tail;
		    	temp.next = node;

		    	tail = node;
		    	tail.previous = temp;
		    	tail.next = null;
		    	tail.value = value;
			}
		}
    }
    
    public void printCache() {
    	Node temp = head;
    	if (temp == null)
    		return;
    	while (temp != null) {
    		System.out.println(temp);
    		temp = temp.next;
    	}
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache( 2 /* capacity */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	System.out.println(cache.get(1));       // returns -1 (not found)
    	System.out.println(cache.get(3));       // returns 3
    	System.out.println(cache.get(4));       // returns 4
    }
    
	private static class Node {
		private int key;
		private int value;
		private Node previous;
		private Node next;
		
		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("key: " + key + ", value: " + value);
			return sb.toString();
		}
	}
    
}