package codefellows.datastructures;

import codefellows.datastructures.ArrayList;
import codefellows.datastructures.List;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    public Set<String> nodes;
    public Map<String, Set<String>> edges;
    public Map<String, Map<String, Integer>> weights;

    public Graph() {
        nodes = new HashSet<>();
        edges = new HashMap<>();
        weights = new HashMap<>();
    }

    public void addNode(String node) {
        if (!nodes.contains(node)) {
            nodes.add(node);
        }

        if (!edges.containsKey(node)) {
            edges.put(node, new HashSet<>());
        }
    }

    // Adds an edge from nodeStart to nodeEnd. This method only creates an
    // edge in a one-way direction. It does not add an edge back from nodeEnd to node Start.
    public void addEdge(String nodeStart, String nodeEnd) {
        if (!edges.containsKey(nodeStart) || !edges.containsKey(nodeEnd)) {
            return;
        }
        Set<String> nodeEdges = this.edges.get(nodeStart);
        if (!nodeEdges.contains(nodeEnd)) {
            nodeEdges.add(nodeEnd);
        }
    }

    // Adds an edge from node1 to node2, and in the reverse direction from
    // node2 back to node1.
    public void addEdgeTwoWay(String node1, String node2) {
        if (!edges.containsKey(node1) || !edges.containsKey(node2)) {
            return;
        }
        Set<String> n1Edges = this.edges.get(node1);
        Set<String> n2Edges = this.edges.get(node2);
        if (!n1Edges.contains(node2)) {
            n1Edges.add(node2);
        }

        if (!n2Edges.contains(node1)) {
            n2Edges.add(node1);
        }
    }

    public void addWeight(String startNode, String endNode, int weight) {
        addEdge(startNode, endNode);
        if (weights.get(startNode) == null) {
            weights.put(startNode, new HashMap<>());
        }
        weights.get(startNode).put(endNode, weight);
    }

    public Set<String> getEdges(String node) {
        if (!edges.containsKey(node)) {
            return new HashSet<>();
        }
        return edges.get(node);
    }
}
