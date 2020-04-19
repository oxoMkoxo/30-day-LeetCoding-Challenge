
/* 155. Min Stack

	Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
 

	Example 1:
		Input
		["MinStack","push","push","push","getMin","pop","top","getMin"]
		[[],[-2],[0],[-3],[],[],[],[]]

		Output
		[null,null,null,null,-3,null,0,-2]

	Explanation
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top();    // return 0
		minStack.getMin(); // return -2
 

	Constraints:
		Methods pop, top and getMin operations will always be called on non-empty stacks.
*/
import java.util.*;

public class MinStack {

	/* initialize your data structure here. */

	class Node {
		int val;
		int minTillThatNode;/* This will store min value of entire stack under that Node Including itself */

		Node(int x, int y) {
			val = x;
			minTillThatNode = y;
		}

	}

	private int size;
	private LinkedList<Node> list; /* addFirst() and removeFirst() and peek() will result in O(1) complexity */

	public MinStack() {
		size = 0;
		list = new LinkedList<>();
	}

	public void push(int x) {
		Node myNode;
		if (size == 0) {
			myNode = new Node(x, x);
		} else {
			int lastNodesMinValue = list.getFirst().minTillThatNode;
			if (x < lastNodesMinValue) {
				myNode = new Node(x, x);
			} else {
				myNode = new Node(x, lastNodesMinValue);
			}
		}
		list.addFirst(myNode);
		size++;
	}

	public void pop() {
		if (size > 0) {
			list.removeFirst();
			size--;
		}

	}

	public int top() {
		return list.peek().val;
	}

	public int getMin() {
		return list.peek().minTillThatNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MinStack obj = new MinStack();
//		obj.push(5);
//		obj.pop();
//		int param_3 = obj.top();
//		int param_4 = obj.getMin();
	}

}
