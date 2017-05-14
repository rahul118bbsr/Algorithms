package algorithms.mishra.dev.rahul.datastructure.stacks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComplementaryPairs {

	public static void main(String[] args) {
//		int[] a = { 1, 3, 46, 1, 3, 9 };
		int[] a = { 6, 6, 3, 9, 3, 5, 1 };
		System.out.println(numberOfPairs(a, 12));

	}

	static int numberOfPairs(int[] a, long k) {
		if (a == null || a.length == 0) {
			return 0;
		}

		Map<Long, Integer> map = new HashMap<>();
		Set<Long> set = new HashSet<>();
		int counter = 0;

		for (int i = 0; i < a.length; i++) {
			map.put((long) a[i], i);
		}

		for (int i = 0; i < a.length; i++) {
			if (map.get(k - a[i]) != null && map.get(k - a[i]) != i) {
				boolean b = set.add((long) a[i]);
				boolean c = set.add(k - a[i]);
				counter =  b || c ? ++counter : counter;
				
			}
		}
		return counter;
	}

}
