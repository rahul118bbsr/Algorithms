package algorithms.mishra.dev.rahul.leetcode.graph.kruskal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aleesha on 18/07/17.
 */
public class KruskalsImpl {
    public static void main(String[] args) {
        Graph graph = new KruskalsImpl().new Graph();
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

        System.out.println(graph.execute());
    }

    class Graph {
        private Map<String, Vertex> map = new HashMap<>();

        public void addEdge(String src, String dest, int weight) {
            Vertex srcNode = map.get(src) == null ? new Vertex(src) : map.get(src);
            Vertex destNode = map.get(dest) == null ? new Vertex(dest) : map.get(dest);
            srcNode.edgeList.add(new Edge(srcNode, destNode, weight));
            map.put(src, srcNode);
            map.put(dest, destNode);
        }

        public List<Edge> execute() {
            List<Edge> sortedEdgeList = addAllEdges();
            DisjointSet disjointSet = new DisjointSet();
            sortedEdgeList.forEach(edge -> {
                disjointSet.createSet(edge.src.name);
                disjointSet.createSet(edge.dest.name);
            });
            List<Edge> resultList = new ArrayList<>();
            for (Edge edge : sortedEdgeList) {
                if (disjointSet.union(edge.src.name, edge.dest.name)) {
                    resultList.add(edge);
                }

                if (resultList.size() == map.keySet().size()) {
                    return resultList;
                }
            }
            return resultList;
        }

        private List<Edge> addAllEdges() {
            return map.values().stream()
                    .flatMap(vertex -> vertex.edgeList.stream())
                    .sorted(Comparator.comparingInt(Edge::getWeight))
                    .collect(Collectors.toList());
        }
    }

    class Edge {
        Vertex src;
        Vertex dest;
        int weight;

        Edge(Vertex src, Vertex dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return src + "-->" + dest + "[" + weight + "]";
        }

        public int getWeight() {
            return weight;
        }
    }

    class Vertex {
        String name;
        List<Edge> edgeList;

        Vertex(String name) {
            this.name = name;
            edgeList = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            return name.equals(vertex.name);
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
}

class DisjointSet {
    private Map<String, Node> map = new HashMap<>();

    public void createSet(String name) {
        if (!Objects.isNull(map.get(name))) {
            return;
        }
        Node node = new Node(name);
        node.parent = node;
        map.put(name, node);
    }

    public Node findSet(String name) {
        if (!Objects.isNull(map.get(name))) {
            return findSet(map.get(name)).parent;
        }
        return null;
    }

    private Node findSet(Node node) {
        if (node == node.parent) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public boolean union(String data1, String data2) {
        if (Objects.isNull(map.get(data1)) || Objects.isNull(map.get(data2))) {
            return false;
        }

        Node parent1 = findSet(map.get(data1));
        Node parent2 = findSet(map.get(data2));
        if (parent1 == parent2) {
            return false;
        }

        if (parent1.rank >= parent2.rank) {
            parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }


    class Node {
        String name;
        int rank;
        Node parent;

        Node(String name) {
            this.name = name;
            this.rank = 0;
        }
    }
}
