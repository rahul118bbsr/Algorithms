/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms.dynamicprogramming;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Jul-2017 7:54:00 PM
 *
 */
public class EggDrop {
	// A utility function to get maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/*
	 * Function to get minimum number of trials needed in worst case with n eggs
	 * and k floors
	 */
	static int eggDrop(int numOfEggs, int numOfFloors) {
		/*
		 * A 2D table where entery eggFloor[i][j] will represent minimum number
		 * of trials needed for i eggs and j floors.
		 */
		int eggFloor[][] = new int[numOfEggs + 1][numOfFloors + 1];
		int res;
		int i, j, x;

		// We need one trial for one floor and 0 trials for 0 floors
		for (i = 1; i <= numOfEggs; i++) {
			eggFloor[i][1] = 1;
			//eggFloor[i][0] = 0; ==> Default value for int is 0.  
		}

		// We always need j trials for one egg and j floors.
		for (j = 1; j <= numOfFloors; j++)
			eggFloor[1][j] = j;

		// Fill rest of the entries in table using optimal substructure property
		for (i = 2; i <= numOfEggs; i++) {
			for (j = 2; j <= numOfFloors; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (x = 1; x <= j; x++) {
					/*
					 * max(eggFloor[i - 1][x - 1], eggFloor[i][j - x])
					 * means eggFloor[eggsRemaining][floorsRemaining]
					 * 1st Max condition: egg broke after dropping (go down and test), so use remaining eggs from i number of eggs and test remaining floors from x number of floors
					 * 2nd Max condition: egg drop survived from xth floor (go up and test), so use "i" eggs and test remaining floors i.e j - x.
					 * 
					 */
					res = 1 + max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
					if (res < eggFloor[i][j])
						eggFloor[i][j] = res;
				}
			}
		}

		// eggFloor[n][k] holds the result
		return eggFloor[numOfEggs][numOfFloors];

	}

	/* Driver program to test to pront printDups */
	public static void main(String args[]) {
		int n = 2, k = 36;
		System.out.println(
				"Minimum number of trials in worst case with " + n + "  eggs and " + k + " floors is " + eggDrop(n, k));
	}
}
