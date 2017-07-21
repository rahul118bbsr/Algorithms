package algorithms.mishra.dev.rahul.leetcode.graph;

import java.util.*;

/**
 * Created by aleesha on 19/07/17.
 */
public class TopologicalSort {
    public static void main(String[] args) {
        Graph graph = new TopologicalSort().new Graph(6);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(5, 2);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(0, 3);
        graph.performTopologicalSort();
    }

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

        public void performTopologicalSort() {
            Stack<Integer> result = new Stack<>();
            Set<Integer> visitedNodes = new HashSet<>();
            for(int i = 0; i < adjList.size(); i++) {
                topologicalSortUtil(i, visitedNodes, result);
            }
            while(!result.isEmpty()) {
                System.out.println(result.pop() + " ");
            }
        }

        private void topologicalSortUtil(int root, Set<Integer> visitedNodes, Stack<Integer> result) {
            if(visitedNodes.contains(root)) {
                return;
            }
            visitedNodes.add(root);
            for(Integer child : adjList.get(root)) {
                topologicalSortUtil(child, visitedNodes, result);
            }
            result.add(root);
        }
    }
}
