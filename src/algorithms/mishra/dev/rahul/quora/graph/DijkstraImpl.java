/**
 *
 */
package algorithms.mishra.dev.rahul.quora.graph;

import java.util.*;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 08-Jul-2017 10:06:58 PM
 */
public class DijkstraImpl {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "E", 2);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "D", 9);
        graph.addEdge("C", "D", 3);
        graph.addEdge("E", "D", 6);
        graph.addEdge("E", "F", 3);
        graph.addEdge("F", "D", 2);
        graph.findShortestPath("A", "D");
    }
}

class Graph {
    private Map<String, Node> vertices = new HashMap<>();

    public void addEdge(String src, String dest, int weight) {
        Node srcNode = vertices.get(src) == null ? new Node(src) : vertices.get(src);
        Node destNode = vertices.get(dest) == null ? new Node(dest) : vertices.get(dest);
        Edge edge = new Edge(srcNode, destNode, weight);
        srcNode.getEdgeList().add(edge);
        vertices.put(src, srcNode);
        // Persist dest as well, otherwise, there would be multiple instances of
        // node with same name, which we don't want.
        vertices.put(dest, destNode);
    }

    public void findShortestPath(String src, String dest) {
        if (src.equals(dest)) {
            return;
        }
        Queue<ShortestDistanceNode> priorityQueue = new PriorityQueue<>(getComparatorBasedOnCurrentRunningTotal());
        priorityQueue.add(new ShortestDistanceNode(vertices.get(src), 0));
        shortestPathUtil(vertices.get(src), vertices.get(dest), priorityQueue);
    }

    private Map<Node, Node> shortestPathUtil(Node currentNode, Node destNode,
                                                             Queue<ShortestDistanceNode> priorityQueue) {
        Map<Node, Node> routeMap = new HashMap<>();
        Map<Node, Integer> map = new HashMap<>();
        Set<Node> visitedNodesSet = new HashSet<>();
        map.put(currentNode, 0);
        routeMap.put(currentNode, null);
        while(currentNode != destNode) {
            ShortestDistanceNode shortestDistanceNode = priorityQueue.poll();
            currentNode = shortestDistanceNode.getNode();
            if(visitedNodesSet.contains(currentNode)) {
               continue;
            }
            visitedNodesSet.add(currentNode);
            for(Edge edge : currentNode.getEdgeList()) {
                ShortestDistanceNode distanceNode = new ShortestDistanceNode(edge.getDest(), shortestDistanceNode.getCurrentRunningTotal() + edge.getWeight());
                if(map.get(distanceNode.getNode()) == null || map.get(distanceNode.getNode()) > distanceNode.getCurrentRunningTotal()) {
                    priorityQueue.add(distanceNode);
                    map.put(distanceNode.getNode(), distanceNode.getCurrentRunningTotal());
                    routeMap.put(edge.getDest(), edge.getSrc());
                }
            }
        }
        return routeMap;
    }

    private void printShortestPath(Node srcNode, Node destNode, Map<Node, ShortestDistanceNode> shortestPathMap) {

    }

    private Comparator<ShortestDistanceNode> getComparatorBasedOnCurrentRunningTotal() {
        return Comparator.comparingInt(ShortestDistanceNode::getCurrentRunningTotal);
    }
}

class Node {
    private String name;
    private List<Edge> edgeList = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }
}

class Edge {
    private Node src;
    private Node dest;
    private int weight;

    public Edge(Node src, Node dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dest == null) ? 0 : dest.hashCode());
        result = prime * result + ((src == null) ? 0 : src.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (dest == null) {
            if (other.dest != null)
                return false;
        } else if (!dest.equals(other.dest))
            return false;
        if (src == null) {
            if (other.src != null)
                return false;
        } else if (!src.equals(other.src))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return src.getName() + "-->" + dest.getName();
    }

    public Node getSrc() {
        return src;
    }

    public Node getDest() {
        return dest;
    }

    public Integer getWeight() {
        return weight;
    }
}

class ShortestDistanceNode {
    private Node node;
    private int currentRunningTotal;

    public ShortestDistanceNode(Node node, int currentRunningTotal) {
        this.node = node;
        this.currentRunningTotal = currentRunningTotal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((node == null) ? 0 : node.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShortestDistanceNode other = (ShortestDistanceNode) obj;
        if (node == null) {
            if (other.node != null)
                return false;
        } else if (!node.equals(other.node))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return node.toString() + " Current Total: " + currentRunningTotal;
    }

    public Node getNode() {
        return node;
    }

    public int getCurrentRunningTotal() {
        return currentRunningTotal;
    }
}
