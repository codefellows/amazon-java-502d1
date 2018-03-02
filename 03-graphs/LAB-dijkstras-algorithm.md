# ![CF](http://i.imgur.com/7v5ASc8.png) Implementing Dijkstra's Algorithm

## Resources
* [Graph Implementations](https://secweb.cs.odu.edu/~zeil/cs361/web/website/Lectures/graphbasics/pages/ar01s02.html)
* [Wikipedia: Dijkstra's Algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Algorithm)

## Feature Tasks
### Implement a Graph
Implement your own Graph. Only use the Graph in the CanonDataStructures
directory as a reference. Try to build your implementation using your own
knowledge and understanding of how Graphs are constructed. Don't just rewrite
the reference Graph implementation verbatim.

Refer to the "Graph Implementations" resource link above to see how to
implement your Graph either as an adjacency matrix, or adjacency list.

Assume there are no duplicate edges between nodes. It should have the following
properties:

* Write one class `GraphNode` to represent a node in the Graph.
  * add a public `String` property `name` so the node has a name.
* `public int size()` - returns the number of nodes in the Graph
* `public Set<GraphNode> getNodes()`
* `public Set<GraphNode> getNeighbors(GraphNode node)`
* `public int getEdgeWeight(GraphNode n1, GraphNode n2)`

### Breadth-First Traversal
Write a program that populates your Graph with several nodes and edges between
them. Write an algorithm that traverses through the entire graph in
a breadth-first traversal starting from one node.

Remember to use a `Set<GraphNode>` to remember which nodes you've visited.

### Dijkstra's Algorithm
Add a method to the Graph class that computes the shortest distance between 
two nodes. Compute the distance using Dijkstra's Algorithm. Refer to Wikipedia
to see a description of the algorithm.

