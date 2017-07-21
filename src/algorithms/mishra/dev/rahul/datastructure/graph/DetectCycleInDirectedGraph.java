package algorithms.mishra.dev.rahul.datastructure.graph;

import java.util.*;

/**
 * Created by aleesha on 20/07/17.
 */
public class DetectCycleInDirectedGraph {

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

        public boolean detectCycle() {
            Set<Integer> visitingNodes = new HashSet<>();
            Set<Integer> visitedNodes = new HashSet<>();
            for(int i = 0; i < adjList.size(); i++) {
                if(hasCycle(i, visitedNodes, visitingNodes)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasCycle(int root, Set<Integer> visitedNodes, Set<Integer> visitingNodes) {
            if(visitingNodes.contains(root)) {
                return true;
            }
            if(visitedNodes.contains(root)) {
                return false;
            }

            visitingNodes.add(root);
            for(Integer child : adjList.get(root)) {
                if(hasCycle(child, visitedNodes, visitingNodes)) {
                    return true;
                }
            }

            visitedNodes.remove(root);
            visitedNodes.add(root);
            return false;
        }
    }
}
