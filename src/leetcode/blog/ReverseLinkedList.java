package leetcode.blog;

import util.LinkedListNode;

public class ReverseLinkedList {
	// Q2 Reverse Linked List both Iteratively and Recursively
	public static LinkedListNode reverseLinkedListIteratively(
			LinkedListNode head) {
		if (head == null)
			return head;
		LinkedListNode res = new LinkedListNode(0);
		LinkedListNode next;
		while (head != null) {
			next = head.next;
			head.next = res.next;
			res.next = head;
			head = next;
		}
		return res.next;
	}

	public static LinkedListNode reverseLinkedListRecursively(
			LinkedListNode head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;
		LinkedListNode newHead = reverseLinkedListRecursively(head.next);
		head.next.next = head;// next points to head
		head.next = null;// head points to null, basically reverse the two nodes
		return newHead;
	}
	
	public static void main(String[] args){
		// Q2
		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		head = reverseLinkedListIteratively(head);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
		
		LinkedListNode head2 = new LinkedListNode(1);
		head2.next = new LinkedListNode(2);
		head2.next.next = new LinkedListNode(3);
		head2 = reverseLinkedListRecursively(head2);
		while (head2 != null) {
			System.out.print(head2.value + " ");
			head2 = head2.next;
		}
		System.out.println();
	}
}
