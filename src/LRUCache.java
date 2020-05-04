import java.util.*;

public class LRUCache {
	private int size;
	private Node Head;
	private Node Tail;
	HashMap<Integer, Node> cache;

	class Node {
		int val;
		int key;
		Node prev;
		Node next;

		public Node() {
			// TODO Auto-generated constructor stub
		}
	}

	public LRUCache(int capacity) {
		size = capacity;
		cache = new HashMap<>();
		Head = null;
		Tail = null;
	}

	public int get(int key) {
		int ans = -1;
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			ans = node.val;
			makeRecent(node);
		}
		return ans;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			node.val = value;
			node.key = key;
			makeRecent(node);
		} else {
			Node node = new Node();
			node.val = value;
			node.key = key;
			if (cache.size() == size) {
				deleteLeastUsed();
				node.next = Head;
				node.prev = null;
				if (Head != null) {
					Head.prev = node;
				}
				Head = node;
				cache.put(key, node);
			} else {
				if (cache.size() == 0) {
					Head = node;
					Tail = node;
				} else {
					node.next = Head;
					node.prev = null;
					Head.prev = node;
					Head = node;
				}

				cache.put(key, Head);
			}
		}
	}

	public void makeRecent(Node node) {
		if (node == Head) {
			return;
		} else if (node == Tail) {
			node.prev.next = null;
			Tail = node.prev;
			Head.prev = node;
			node.next = Head;
			node.prev = null;
			Head = node;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			Head.prev = node;
			node.next = Head;
			node.prev = null;
			Head = node;
		}

	}

	public void deleteLeastUsed() {
		if (cache.size() == 1) {
			cache.remove(Tail.key);
			Head = Tail = null;
		} else {
			Tail.prev.next = null;
			cache.remove(Tail.key);
			if (cache.size() == 1) {
				Tail = Head;
			} else if (cache.size() == 0) {
				Head = Tail = null;
			} else {

				Tail = Tail.prev;
				Tail.next = null;
			}
		}
	}

	public void display() {
		Node temp = Head;
		System.out.print("Head->");
		while(temp!=null) {
			System.out.print("{" + temp.key + ", " + temp.val + "}->" );
			temp = temp.next;
		}
		System.out.println("Tail");
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
//		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		cache.display();
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		cache.display();
		cache.get(1); // returns -1 (not found)
		cache.get(3); // returns 3
		cache.get(4); // returns 4
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */