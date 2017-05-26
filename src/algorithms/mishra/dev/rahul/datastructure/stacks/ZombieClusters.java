package algorithms.mishra.dev.rahul.datastructure.stacks;

/**
 * Audible Hackerrank Question
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 19-May-2017 3:50:35 PM
 *
 */
public class ZombieClusters {

	public static void main(String[] args) {
		 String[] strings = new String[]{
	                "5",
	                "10000",
	                "01000",
	                "00100",
	                "00010",
	                "00001"
	        };

	        int count = zombieCluster(strings);
	        System.out.println(count);
	}
	
	static int zombieCluster(String[] zombies) {

        int N = Integer.parseInt(zombies[0]);

        int[][] M = new int [N][N];
        for(int i = 0; i<N; i++) {
            for (int j = 0 ; j<N; j++) {
                M[i][j] = Integer.parseInt(zombies[i + 1].charAt(j) + "");
            }
        }

        boolean visited[] = new boolean[N];
        boolean visiting[] = new boolean[N];

        int count = 0;
        for (int i = 0; i < N; ++i) {
            if(!visited[i]) {
                visiting[i] = true;
                DFS(M, N, visited, visiting, i);
                visited[i] = true;
                count++;
            }
        }
        return count;
    }

    static void DFS(int M[][], int N, boolean visited[], boolean[] visiting, int s)
    {
        if( !visited[s] ) {
            visiting[s] = true;
            for(int j = s+1; j < N; j++) {
                if(M[s][j] == 1 && !visited[j]) {
                    visiting[j] = true;
                    DFS(M, N, visited, visiting, j);
                    visited[j] = true;
                }
            }
        }
    }

}
