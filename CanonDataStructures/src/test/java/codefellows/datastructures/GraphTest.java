package codefellows.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.junit.Assert.*;

public class GraphTest {
    Graph mGraph = new Graph();

    @Before
    public void buildWashington() {
        mGraph = new Graph();
        mGraph.addNode("Bellingham");
        mGraph.addNode("Seattle");
        mGraph.addNode("Tacoma");
        mGraph.addNode("Olympia");

        mGraph.addNode("Ellensburg");
        mGraph.addNode("Yakima");
        mGraph.addNode("Spokane");

        mGraph.addNode("Richland");
        mGraph.addNode("Kennewick");
        mGraph.addNode("Pasco");

        // Hawaii is an island unto itself
        mGraph.addNode("Hawaii");

        // north-south I5 corridor
        mGraph.addEdgeTwoWay("Bellingham", "Seattle");
        mGraph.addEdgeTwoWay("Seattle", "Tacoma");
        mGraph.addEdgeTwoWay("Tacoma", "Olympia");

        // east west I90 corridor
        mGraph.addEdgeTwoWay("Seattle", "Ellensburg");
        mGraph.addEdgeTwoWay("Ellensburg", "Spokane");
        mGraph.addEdgeTwoWay("Ellensburg", "Yakima");

        mGraph.addEdgeTwoWay("Yakima", "Richland");

        // super-local tri-city area
        mGraph.addEdgeTwoWay("Richland", "Kennewick");
        mGraph.addEdgeTwoWay("Richland", "Pasco");
        mGraph.addEdgeTwoWay("Pasco", "Kennewick");
    }

    @Test
    public void washingtonState() {
        assertEquals(11, mGraph.nodes.size());
    }

    @Test
    public void testConnectedness() {
        Set<String> visited = new HashSet<>();
        Queue<String> qq = new LinkedList<>();
        qq.add("Seattle");

        while (!qq.isEmpty()) {
            String city = qq.remove();
            List<String> neighborCities = mGraph.getEdges(city);
            for (int i = 0; i < neighborCities.size(); i++) {
                String neighborCity = neighborCities.get(i);
                if (!visited.contains(neighborCity)) {
                    qq.add(neighborCity);
                }
            }
            visited.add(city);
        }

        assertEquals(10, visited.size());
    }

    @Test
    public void testHawaiiIsland() {
        assertEquals(0, mGraph.getEdges("Hawaii").size());
    }
}