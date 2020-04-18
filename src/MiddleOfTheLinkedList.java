
// 876. Middle of the Linked List
//
//	Given a non-empty, singly linked list with head node head, return a middle node of linked list.
//	If there are two middle nodes, return the second middle node.
//
//	Example 1:
//		Input: [1,2,3,4,5]
//		Output: Node 3 from this list (Serialization: [3,4,5])
//		The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
//		Note that we returned a ListNode object ans, such that:
//		ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
//
//	Example 2:
//		Input: [1,2,3,4,5,6]
//		Output: Node 4 from this list (Serialization: [4,5,6])
//		Since the list has two middle nodes with values 3 and 4, we return the second one.
// 
//
//	Note:
//	The number of nodes in the given list will be between 1 and 100.
import java.util.*;

public class MiddleOfTheLinkedList {
	public class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine().trim();
		String[] arr = s.split("[\\[\\],]");
		scn.close();
		MiddleOfTheLinkedList list = new MiddleOfTheLinkedList();
		ListNode head = null;
		ListNode temp = null;
		for (int i = 1; i < arr.length; i++) {
			ListNode node = list.new ListNode(Integer.parseInt(arr[i]));
			if (i == 1) {
				head = node;
				temp = node;
			} else {
				temp.next = node;
				temp = node;
			}
		}
		if (head != null) {
			temp = middleNode(head);
			display(temp);
		} else {
			System.out.print("[]");
		}

	}

	public static void display(ListNode head) {
		System.out.print("[");
		while (head.next != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.print(head.val + "]");
	}

	public static ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// System.out.println(slow.val);
		return slow;
	}

}
