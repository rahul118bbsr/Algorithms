package algorithms.mishra.dev.rahul.datastructure.graph;

import java.util.*;

/**
 * Created by aleesha on 20/07/17.
 */
public class GraphDFSTraversal {

    class Graph {
        private List<List<Integer>> adjList;
        public Graph(int numOfVertices) {
            adjList = new ArrayList<>();
            for(int i = 0; i < numOfVertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dest) {
            adjList.get(src).add(dest);
        }

        public void dfsTraversal(int root) {
            Stack<Integer> stack = new Stack<>();
            Set<Integer> visitedNodes = new HashSet<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                int node = stack.pop();
                if(visitedNodes.contains(node)) {
                    continue;
                }
                visitedNodes.add(node);
                for(Integer child : adjList.get(node)) {
                    if(visitedNodes.contains(child)) {
                        continue;
                    }
                    stack.push(child);
                }
            }
        }
    }
}
