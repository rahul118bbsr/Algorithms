package algorithms.mishra.dev.rahul.leetcode.graph.prim;

import java.util.*;

/**
 * Created by aleesha on 18/07/17.
 */
public class PrimsImpl {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 4);
        graph.addEdge("B", "A", 4);
        graph.addEdge("A", "I", 8);
        graph.addEdge("I", "A", 8);
        graph.addEdge("B", "I", 11);
        graph.addEdge("I", "B", 11);
        graph.addEdge("B", "C", 8);
        graph.addEdge("C", "B", 8);
        graph.addEdge("I", "H", 7);
        graph.addEdge("H", "I", 7);
        graph.addEdge("I", "G", 1);
        graph.addEdge("G", "I", 1);
        graph.addEdge("C", "D", 7);
        graph.addEdge("D", "C", 7);
        graph.addEdge("C", "H", 2);
        graph.addEdge("H", "C", 2);
        graph.addEdge("C", "F", 4);
        graph.addEdge("F", "C", 4);
        graph.addEdge("H", "G", 6);
        graph.addEdge("G", "H", 6);
        graph.addEdge("G", "F", 2);
        graph.addEdge("F", "G", 2);
        graph.addEdge("D", "F", 14);
        graph.addEdge("F", "D", 14);
        graph.addEdge("D", "E", 9);
        graph.addEdge("E", "D", 9);
        graph.addEdge("E", "F", 10);
        graph.addEdge("F", "E", 10);

        System.out.println(graph.execute("A"));
    }
}

class Graph{
    private Map<String, Node> map = new HashMap<>();

    public void addEdge(String src, String dest, int weight) {
        Node srcNode = map.get(src) == null ? new Node(src) : map.get(src);
        Node destNode = map.get(dest) == null ? new Node(dest) : map.get(dest);
        srcNode.edgeList.add(new Edge(srcNode, destNode, weight));
        map.put(src, srcNode);
        map.put(dest, destNode);
    }

    public List<Edge> execute(String src) {
        if(Objects.isNull(src) || Objects.isNull(map.get(src))) {
            return null;
        }
        Node srcNode = map.get(src);
        Set<Node> visitedNodesSet = new HashSet<>();
        visitedNodesSet.add(srcNode);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(getComparatorBasedOnEdgeWeight());
        priorityQueue.addAll(srcNode.edgeList);
        return primsUtil(priorityQueue, visitedNodesSet);
    }

    private List<Edge> primsUtil(PriorityQueue<Edge> priorityQueue, Set<Node> visitedNodesSet) {
        List<Edge> resultList = new ArrayList<>();
        while(visitedNodesSet.size() != map.keySet().size()) {
            Edge edge = priorityQueue.poll();
            Node dest = edge.dest;
            if(visitedNodesSet.contains(dest)) {
                continue;
            }
            visitedNodesSet.add(dest);
            priorityQueue.addAll(dest.edgeList);
            resultList.add(edge);
        }
        return resultList;
    }

    private Comparator<Edge> getComparatorBasedOnEdgeWeight() {
        return Comparator.comparingInt(Edge::getWeight);
    }
}

class Node {
    String name;
    List<Edge> edgeList;

    public Node(String name) {
        this.name = name;
        edgeList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}

class Edge {
    Node src;
    Node dest;
    int weight;

    public Edge(Node src, Node dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return src + "-->" + dest + "[" + weight + "]";
    }
}
