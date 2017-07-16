package algorithms.mishra.dev.rahul.quora.arrays;

/**
 * Created by aleesha on 12/07/17.
 */
public class SpiralTraversalArray {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new SpiralTraversalArray().spiralTraversal(array);
    }

    public void spiralTraversal(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            if(i % 2 == 0) {
                performLRTraversal(i, array);
            } else {
                performRLTraversal(i, array);
            }
            System.out.println();
        }
    }

    private void performLRTraversal(int i, int[][] array) {
        for(int j = 0; j <= array[0].length - 1; j++) {
            System.out.print(array[i][j] + " ");
        }
    }

    private void performRLTraversal(int i, int[][] array) {
        for (int j = array[0].length - 1; j >= 0; j--) {
            System.out.print(array[i][j] + " ");
        }
    }
}
