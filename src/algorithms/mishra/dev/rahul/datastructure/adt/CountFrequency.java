/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 29-May-2017 12:01:51 PM
 *
 */
public class CountFrequency {
	// Function to find counts of all elements present in
    // arr[0..n-1]. The array elements must be range from
    // 1 to n
    void printfrequency(int arr[], int n) 
    {
        // Subtract 1 from every element so that the elements
        // become in range from 0 to n-1
        for (int j = 0; j < n; j++)
            arr[j] = arr[j] - 1;
 
        // Use every element arr[i] as index and add 'n' to
        // element present at arr[i]%n to keep track of count of
        // occurrences of arr[i]
        for (int i = 0; i < n; i++)
            arr[arr[i] % n] = arr[arr[i] % n] + n;
 
        // To print counts, simply print the number of times n
        // was added at index corresponding to every element
        for (int i = 0; i < n; i++)
            System.out.println(i + 1 + "->" + arr[i] / n);
    }
 
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        CountFrequency count = new CountFrequency();
        int arr[] = {2, 3, 3, 2, 5};
        int n = arr.length;
        count.printfrequency(arr, n);
    }

}
