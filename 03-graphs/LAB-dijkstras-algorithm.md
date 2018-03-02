# ![CF](http://i.imgur.com/7v5ASc8.png) Implementing Dijkstra's Algorithm

## Resources
* [Wikipedia: Dijkstra's Algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Algorithm)

## Feature Tasks
### Implement a Graph
Implement your own Graph. Assume there are no duplicate edges between nodes. It should have the following properties:

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

