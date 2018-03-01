package codefellows.datastructures;

import codefellows.datastructures.ArrayList;
import codefellows.datastructures.List;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    public List<String> nodes;
    public Map<String, ArrayList<String>> edges;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new HashMap<>();
    }

    public void addNode(String node) {
        if (!nodes.contains(node)) {
            nodes.append(node);
        }

        if (!edges.containsKey(node)) {
            edges.put(node, new ArrayList<>());
        }
    }

    // Adds an edge from nodeStart to nodeEnd. This method only creates an
    // edge in a one-way direction. It does not add an edge back from nodeEnd to node Start.
    public void addEdge(String nodeStart, String nodeEnd) {
        if (!edges.containsKey(nodeStart) || !edges.containsKey(nodeEnd)) {
            return;
        }
        List<String> nodeEdges = this.edges.get(nodeStart);
        if (!nodeEdges.contains(nodeEnd)) {
            nodeEdges.append(nodeEnd);
        }
    }

    // Adds an edge from node1 to node2, and in the reverse direction from
    // node2 back to node1.
    public void addEdgeTwoWay(String node1, String node2) {
        if (!edges.containsKey(node1) || !edges.containsKey(node2)) {
            return;
        }
        List<String> n1Edges = this.edges.get(node1);
        List<String> n2Edges = this.edges.get(node2);
        if (!n1Edges.contains(node2)) {
            n1Edges.append(node2);
        }

        if (!n2Edges.contains(node1)) {
            n2Edges.append(node1);
        }
    }

    public List<String> getEdges(String node) {
        if (!edges.containsKey(node)) {
            return new ArrayList<>();

        }
        return edges.get(node);
    }
}
