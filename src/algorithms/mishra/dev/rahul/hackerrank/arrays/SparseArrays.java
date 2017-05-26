/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-May-2017 5:13:03 PM
 *
 */
public class SparseArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.valueOf(scanner.nextLine());
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(scanner.nextLine());
		}

		int Q = Integer.valueOf(scanner.nextLine());
		String[] queries = new String[Q];
		for (int i = 0; i < Q; i++) {
			queries[i] = scanner.nextLine();
		}
		scanner.close();

		int[] result = caclulate(list, queries);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

		// Java 8 version
		List<String> strings = IntStream.range(0, scanner.nextInt())
				.mapToObj(i -> scanner.next())
				.collect(Collectors.toList());
		
		IntStream.range(0, scanner.nextInt())
				.mapToObj(i -> scanner.next())
				.mapToLong(q -> strings.stream()
						.filter(q::equals).count())
				.forEach(System.out::println);

	}

	private static int[] caclulate(List<String> list, String[] queries) {
		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int count = 0;
			String query = queries[i];
			if (list.contains(query)) {
				for (String word : list) {
					count = query.equals(word) ? count + 1 : count;
				}
			}
			result[i] = count;
		}
		return result;
	}

}
