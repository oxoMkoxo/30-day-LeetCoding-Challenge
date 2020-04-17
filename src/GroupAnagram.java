
//49. Group Anagrams
//
//	Given an array of strings, group anagrams together.
//
//	Example:
//		Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//		Output:
//		[
//		  ["ate","eat","tea"],
//		  ["nat","tan"],
//		  ["bat"]
//		]
//
//	Note:
//		All inputs will be in lowercase.
//		The order of your output does not matter.

import java.util.*;

public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		String[] strs = new String[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			strs[i] = scn.next();
		}
		System.out.println(groupAnagrams(strs));
		scn.close();

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String ns = strs[i];
			char[] arr = ns.toCharArray();
			Arrays.sort(arr);
			String s = new String(arr);
			if (map.containsKey(s)) {
				List<String> l = map.get(s);
				l.add(strs[i]);
				map.put(s, l);
			} else {
				List<String> l = new LinkedList<>();
				l.add(strs[i]);
				map.put(s, l);
			}

		}
		List<List<String>> ans = new LinkedList<>();
		Set<String> set = map.keySet();
		for (String temp : set) {
			ans.add(map.get(temp));
		}
		return ans;

	}

}
