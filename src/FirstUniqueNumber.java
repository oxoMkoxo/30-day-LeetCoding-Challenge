
/*
 * 1429. First Unique Number
 * 
 * 	You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * 	
 * 	Implement the firstUnique class
 * 	  FirstUnique(int[] nums) -> initializes the object with the numbers in queue.
 * 	  int showFirstUnique()-> returns the value of the first unique integer of the queue, and returns -1 if there is no such integer
 *	  void add(int value) insert value to the queue.		
 * 
 * 
 */
import java.util.*;

public class FirstUniqueNumber {

	LinkedHashSet<Integer> unique;
	HashSet<Integer> repeated;

	public FirstUniqueNumber(int[] nums) {
		unique = new LinkedHashSet<>();
		repeated = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!repeated.contains(nums[i])) {
				if (unique.contains(nums[i])) {
					unique.remove(nums[i]);
					repeated.add(nums[i]);
				} else {
					unique.add(nums[i]);
				}
			}
		}
	}

	public int showFirstUnique() {
		// Iterator<Integer> itr = unique.iterator();
		// if(itr.hasNext()){
		// return itr.next();
		// }else{
		// return -1;
		// }
		for (int n : unique) {
			return n;
		}
		return -1;
	}

	public void add(int value) {
		if (!repeated.contains(value)) {
			if (unique.contains(value)) {
				unique.remove(value);
				repeated.add(value);
			} else {
				unique.add(value);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
//		int size = scn.nextInt();
//		int[] nums = new int[size];
//		for (int i = 0; i < size; i++) {
//			nums[i] = scn.nextInt();
//		}
		int[] nums = { 2, 3, 5 };
		FirstUniqueNumber obj = new FirstUniqueNumber(nums);
		System.out.println(obj.showFirstUnique()); // returns 2
		obj.add(5); // queue is now [2,3,5,5]
		obj.add(2); // queue is now [2,3,5,5,2]
		System.out.println(obj.showFirstUnique()); // returns 3
		scn.close();
	}

}
